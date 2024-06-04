package com.riwi.filtro.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionsQuestionResp {

  private Long id;
  private String text;
  private Boolean active;
  
}
