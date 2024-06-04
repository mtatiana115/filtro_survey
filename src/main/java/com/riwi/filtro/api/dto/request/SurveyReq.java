package com.riwi.filtro.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyReq {

  @NotBlank(message = "Username required")
  private String title;

  private String description;

  @NotNull(message = "true is  required")
  private Boolean active;

  @NotNull(message = "userId is required")
  private Long userId;
}
