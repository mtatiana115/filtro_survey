package com.riwi.filtro.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReq {

  @NotBlank(message = "name is required")
  @Size(min=4,max = 100, message = "Name must be between 4 and 50 characters")
  private String name;

  @NotBlank(message = "password is required")
  @Size(min=4,max = 255, message = "password must be between 4 and 255 characters")
  private String password;

  @NotBlank(message = "email is required")
  @Email(message = "Not valid email")
  @Size(max = 100, message = "Email is too long")
  private String email;

  private Boolean active;

}
