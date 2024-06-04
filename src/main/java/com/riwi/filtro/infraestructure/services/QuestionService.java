package com.riwi.filtro.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.QuestionReq;
import com.riwi.filtro.api.dto.response.QuestionResp;
import com.riwi.filtro.domain.entities.OptionsQuestion;
import com.riwi.filtro.domain.entities.Question;
import com.riwi.filtro.domain.repositories.QuestionRepository;
import com.riwi.filtro.infraestructure.abstract_services.IQuestionService;
import com.riwi.filtro.infraestructure.helpers.QuestionHelper;
import com.riwi.filtro.utils.enums.SortType;
import com.riwi.filtro.utils.enums.TypeQuestion;
import com.riwi.filtro.utils.exception.BadRequestException;
import com.riwi.filtro.utils.message.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService{

  @Autowired
  private final QuestionRepository questionRepository;



  @Override
  public QuestionResp getById(Long id) {
    return QuestionHelper.questionToResp(this.find(id));
  }

  @Override
  public QuestionResp update(QuestionReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    questionRepository.delete(this.find(id));
  }

  @Override
  public Page<QuestionResp> getAll(int page, int size, SortType sortType) {
        if (page < 0) page = 0;

    PageRequest pagination = null;

    //validar de que tipo es el sortType
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
      default -> throw new IllegalArgumentException("No valid sort: " + sortType);
        
    }

    return this.questionRepository.findAll(pagination).map(question -> QuestionHelper.questionToResp(question));
  }
  
  private Question find(Long id){
    return this.questionRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("question")));
  }

  @Override
  public QuestionResp create(QuestionReq request) {
    // Question question = new Question();
    
    // if (request.getType().equals(TypeQuestion.CLOSED)) {

    //   question = questionRepository.save(QuestionHelper.reqToQuestion(request));

    //   Question question2 = getById(question.getId());

    
    
  
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");

  }


}
