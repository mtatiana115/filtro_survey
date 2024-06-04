package com.riwi.filtro.api.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SurveyResp {

    private Long id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private Boolean active;

}
