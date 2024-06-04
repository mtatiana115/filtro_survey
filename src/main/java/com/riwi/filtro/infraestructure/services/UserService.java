package com.riwi.filtro.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.UserReq;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.domain.entities.User;
import com.riwi.filtro.domain.repositories.UserRepository;
import com.riwi.filtro.infraestructure.abstract_services.IUserService;
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
    User user = this.requestToEntity(request);
    return this.entityToResp(this.userRepository.save(user));
  }

  @Override
  public UserResp getById(Long id) {
    return this.entityToResp(this.find(id));
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
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  private UserResp entityToResp(User entity){
    return UserResp.builder()
          .id(entity.getId())
          .username(entity.getUsername())
          .email(entity.getEmail())
          .fullName(entity.getFullName())
          .roleUser(entity.getRoleUser())
          .build();
  }

  private User requestToEntity(UserReq request){
    //sintaxis con el builder
    return User.builder()
    .username(request.getUserName())
    .password(request.getPassword())
    .email(request.getEmail())
    .fullName(request.getFullName())
    .roleUser(request.getRoleUser())
    .build();
  }

  private User find(Long id){
    return this.userRepository.findById(id)
      .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("user")));
  }



}
