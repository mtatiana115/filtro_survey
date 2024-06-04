package com.riwi.filtro.infraestructure.abstract_services;

import com.riwi.filtro.api.dto.request.UserReq;
import com.riwi.filtro.api.dto.response.UserResp;

public interface IUserService extends CrudService <UserReq, UserResp, Long> {

}
