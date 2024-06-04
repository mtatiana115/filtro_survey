package com.riwi.filtro.infraestructure.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.QuestionReq;
import com.riwi.filtro.api.dto.response.QuestionResp;
import com.riwi.filtro.domain.repositories.QuestionRepository;
import com.riwi.filtro.infraestructure.abstract_services.IQuestionService;
import com.riwi.filtro.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService{

  private final QuestionRepository questionRepository;

  @Override
  public QuestionResp create(QuestionReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public QuestionResp getById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getById'");
  }

  @Override
  public QuestionResp update(QuestionReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<QuestionResp> getAll(int page, int size, SortType sortType) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAll'");
  }

  @Override
  public QuestionResp textUpdate() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'textUpdate'");
  }



}
