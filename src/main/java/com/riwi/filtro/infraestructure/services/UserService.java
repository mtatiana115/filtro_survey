package com.riwi.filtro.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.UserReq;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.domain.entities.User;
import com.riwi.filtro.domain.repositories.UserRepository;
import com.riwi.filtro.infraestructure.abstract_services.IUserService;
import com.riwi.filtro.infraestructure.helpers.UserHelper;
import com.riwi.filtro.utils.enums.SortType;
import com.riwi.filtro.utils.exception.BadRequestException;
import com.riwi.filtro.utils.message.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

  @Autowired
  private final UserRepository userRepository;

  @Override
  public UserResp create(UserReq request) {
    
    User user = UserHelper.reqToUser(request);
    return UserHelper.userToResp(this.userRepository.save(user));
  }

  @Override
  public UserResp getById(Long id) {
    return UserHelper.userToResp(this.find(id));
  }

  @Override
  public UserResp update(UserReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<UserResp> getAll(int page, int size, SortType sortType) {
    if (page < 0) page = 0;

    PageRequest pagination = null;

    //validar de que tipo es el sortType
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
      default -> throw new IllegalArgumentException("No valid sort: " + sortType);
        
    }

    return this.userRepository.findAll(pagination).map(user -> UserHelper.userToResp(user));
  }

  
  private User find(Long id){
    return this.userRepository.findById(id)
      .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
  }



}
