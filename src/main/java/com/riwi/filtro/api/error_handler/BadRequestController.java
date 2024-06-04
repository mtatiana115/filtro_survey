package com.riwi.filtro.api.error_handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.filtro.api.dto.errors.BaseErrorResponse;
import com.riwi.filtro.api.dto.errors.ErrorResp;
import com.riwi.filtro.utils.exception.BadRequestException;


@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public com.riwi.filtro.api.dto.errors.BaseErrorResponse handleBadRequest(
      MethodArgumentNotValidException exception){

      List<String> errors = new ArrayList<>();

      exception.getAllErrors()
              .forEach(error -> errors.add(error.getDefaultMessage()));
          
      return ErrorResp.builder()
                  .code(HttpStatus.BAD_REQUEST.value())
                  .status(HttpStatus.BAD_REQUEST.name())
                  .errors(errors)
                  .build();
  }

  @ExceptionHandler(BadRequestException.class)
  public BaseErrorResponse badRequest(BadRequestException exception){
      List<String> errors = new ArrayList<>();

      errors.add(exception.getMessage());

      return ErrorResp.builder()
          .code(HttpStatus.BAD_REQUEST.value())
          .status(HttpStatus.BAD_REQUEST.name())
          .errors(errors)
          .build();
  }
}
