package com.riwi.filtro.api.dto.request;

import java.util.List;

import com.riwi.filtro.utils.enums.TypeQuestion;

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
public class QuestionReq {

  @NotBlank(message = "Text is required")
  private String text;

  @NotNull(message = "type question is required")
  private TypeQuestion type;

  @NotNull(message = "true is required")
  private Boolean active;

  @NotNull(message = "surveyId is required")
  private Long surveyId;

  private List <OptionsQuestionReq> options;

}
