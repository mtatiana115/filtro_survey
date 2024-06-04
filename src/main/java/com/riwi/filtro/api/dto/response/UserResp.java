package com.riwi.filtro.api.dto.response;

import com.riwi.filtro.utils.enums.RoleUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResp {
  private Long id;

  private String username;

  private String email;

  private String fullName;

  private RoleUser roleUser;
}
