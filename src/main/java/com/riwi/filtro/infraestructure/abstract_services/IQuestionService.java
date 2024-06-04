package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.QuestionReq;
import com.riwi.filtro.api.dto.response.QuestionResp;

public interface IQuestionService extends  CrudService <QuestionReq, QuestionResp, Long> {

  public final String FIELD_BY_SORT = "type";
}
