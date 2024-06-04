package com.riwi.filtro.infraestructure.helpers;

import com.riwi.filtro.api.dto.request.OptionsQuestionReq;
import com.riwi.filtro.api.dto.response.OptionsQuestionResp;
import com.riwi.filtro.domain.entities.OptionsQuestion;

public class OptionsQuestionHelper {

  public static OptionsQuestionResp questionToResp(OptionsQuestion option) {
    return OptionsQuestionResp.builder()
            .id(option.getId())
            .text(option.getText())
            .active(option.getActive())
            .build();
}

public static OptionsQuestion reqToQuestion(OptionsQuestionReq optionReq) {
    return OptionsQuestion.builder()
            .text(optionReq.getText())
            .active(optionReq.getActive())
            .build();
}
}
