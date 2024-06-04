package com.riwi.filtro.api.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.api.dto.response.SurveyResp;
import com.riwi.filtro.infraestructure.abstract_services.ISurveyService;
import com.riwi.filtro.utils.enums.SortType;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/surveys")
public class SuveyController {

  @Autowired
  private ISurveyService iSurveyService;

    @Operation(summary = "Get the entire surveys list in a paginated manner")
    @GetMapping
    public ResponseEntity<Page<SurveyResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType)) {
            sortType = SortType.NONE;
        }
        return ResponseEntity.ok(this.iSurveyService.getAll(page -1, size, sortType));
    }
}
