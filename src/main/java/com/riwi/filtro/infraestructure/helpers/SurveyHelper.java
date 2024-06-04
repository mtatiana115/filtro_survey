package com.riwi.filtro.infraestructure.helpers;

import com.riwi.filtro.api.dto.request.SurveyReq;
import com.riwi.filtro.api.dto.response.SurveyResp;
import com.riwi.filtro.domain.entities.Survey;

public class SurveyHelper {
      public static SurveyResp surveyToResp(Survey survey) {
        return SurveyResp.builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .creationDate(survey.getCreationDate())
                .active(survey.getActive())
                .user(survey.getUser())
                .questions(survey.getQuestions().stream().map(question -> QuestionHelper.questionToResp(question)).toList())
                .build();
    }

    public static Survey reqToSurvey(SurveyReq surveyReq) {
        return Survey.builder()
                .title(surveyReq.getTitle())
                .description(surveyReq.getDescription())
                .active(surveyReq.getActive())
                .build();
    }

}
