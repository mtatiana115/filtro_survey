package com.riwi.filtro.api.dto.response;

import java.util.List;

import com.riwi.filtro.utils.enums.TypeQuestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionResp {

  private Long id;
  private String text;
  private TypeQuestion type;
  private Boolean active;
  
  private List<OptionsQuestionResp> options;

}
