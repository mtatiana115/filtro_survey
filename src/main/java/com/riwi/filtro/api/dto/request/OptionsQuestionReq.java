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
public class OptionsQuestionReq {

  @NotBlank(message = "Text is required")
  private String text;


  @NotNull(message = "true is  required")
  private Boolean active;

  @NotNull(message = "questionId is required")
  private Long questionId;

}
