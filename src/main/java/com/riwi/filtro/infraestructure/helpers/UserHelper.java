package com.riwi.filtro.infraestructure.helpers;

import com.riwi.filtro.api.dto.request.UserReq;
import com.riwi.filtro.api.dto.response.UserResp;
import com.riwi.filtro.domain.entities.User;

public class UserHelper {
  
  public static UserResp userToResp(User user) {
        return UserResp.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .active(user.getActive())
                .build();
  }

  public static User reqToUser(UserReq userReq) {
        return User.builder()
                .name(userReq.getName())
                .password(userReq.getPassword())
                .email(userReq.getEmail())
                .active(userReq.getActive())
                .build();
  }
}
