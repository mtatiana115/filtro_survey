package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.OptionsQuestionReq;
import com.riwi.filtro.api.dto.response.OptionsQuestionResp;

public interface IOptionsQuestionService extends CrudService <OptionsQuestionReq, OptionsQuestionResp, Long>{

  public final String FIELD_BY_SORT = "id";
}
