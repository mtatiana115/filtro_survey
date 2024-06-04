package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.SurveyReq;
import com.riwi.filtro.api.dto.response.SurveyResp;

public interface ISurveyService extends CrudService <SurveyReq, SurveyResp, Long> {

  public final String FIELD_BY_SORT = "creationDate";
}
