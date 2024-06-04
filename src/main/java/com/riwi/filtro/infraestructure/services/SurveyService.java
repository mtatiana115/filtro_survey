package com.riwi.filtro.infraestructure.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.SurveyReq;
import com.riwi.filtro.api.dto.response.QuestionResp;
import com.riwi.filtro.api.dto.response.SurveyResp;
import com.riwi.filtro.api.dto.response.SurveyRespWithQuestions;
import com.riwi.filtro.domain.entities.Survey;
import com.riwi.filtro.domain.repositories.QuestionRepository;
import com.riwi.filtro.domain.repositories.SurveyRepository;
import com.riwi.filtro.domain.repositories.UserRepository;
import com.riwi.filtro.infraestructure.abstract_services.ISurveyService;
import com.riwi.filtro.infraestructure.helpers.EmailHelper;
import com.riwi.filtro.infraestructure.helpers.QuestionHelper;
import com.riwi.filtro.infraestructure.helpers.SurveyHelper;
import com.riwi.filtro.utils.enums.SortType;
import com.riwi.filtro.utils.exception.BadRequestException;
import com.riwi.filtro.utils.message.ErrorMessage;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService{
  
  @Autowired
  private SurveyRepository surveyRepository;

  // @Autowired
  // private QuestionRepository questionRepository;

  @Autowired
  private final EmailHelper emailHelper;

    @Autowired
    private UserRepository userRepository;


  @Override
  public SurveyResp create(SurveyReq request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public SurveyResp getById(Long id) {
    return SurveyHelper.surveyToResp(this.find(id));
  }

  @Override
  public SurveyResp update(SurveyReq request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public Page<SurveyResp> getAll(int page, int size, SortType sortType) {
    if (page < 0) page = 0;

    PageRequest pagination = null;

    //validar de que tipo es el sortType
    switch (sortType) {
      case NONE -> pagination = PageRequest.of(page, size);
      case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
      default -> throw new IllegalArgumentException("No valid sort: " + sortType);
        
    }

    return this.surveyRepository.findAll(pagination).map(survey -> SurveyHelper.surveyToResp(survey));
  }

  private Survey find (Long id){
    return this.surveyRepository.findById(id)
    .orElseThrow(() -> new BadRequestException(ErrorMessage.idNotFound("survey")));
  }

  public SurveyRespWithQuestions getSurveyByIdWithQuestion(long id) {
    
      Survey survey = find(id);
        return SurveyRespWithQuestions.builder()
                .id(survey.getId())
                .description(survey.getDescription())
                .creationDate(survey.getCreationDate())
                .title(survey.getTitle())
                .active(survey.getActive())
                .questions(survey.getQuestions().stream().map(question -> QuestionHelper.questionToResp(question))
                        .toList())
                .build();
  }

}
