package com.riwi.filtro.infraestructure.helpers;

import java.util.ArrayList;

import com.riwi.filtro.api.dto.request.QuestionReq;
import com.riwi.filtro.api.dto.response.QuestionResp;
import com.riwi.filtro.domain.entities.Question;
import com.riwi.filtro.utils.enums.TypeQuestion;

public class QuestionHelper {

  public static QuestionResp questionToResp(Question question) {
        if (question.getType().equals(TypeQuestion.OPEN)) {
            return QuestionResp.builder()
                .id(question.getId())
                .text(question.getText())
                .type(question.getType())
                .active(question.getActive())
                .options(new ArrayList<>())
                .build();
        }
        return QuestionResp.builder()
                .id(question.getId())
                .text(question.getText())
                .type(question.getType())
                .active(question.getActive())
                .options(question.getOptions().stream().map(option-> OptionsQuestionHelper.questionToResp(option)).toList())
                .build();
    }

    public static Question reqToQuestion(QuestionReq questionReq) {
        return Question.builder()
                .text(questionReq.getText())
                .type(questionReq.getType())
                .active(questionReq.getActive())
                .build();
    }

}
