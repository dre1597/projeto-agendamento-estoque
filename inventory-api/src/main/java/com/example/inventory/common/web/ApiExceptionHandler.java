package com.example.inventory.common.web;

import com.example.inventory.common.domain.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<ApiError> handle(DomainException exception) {
    ApiError body = new ApiError(exception.getCode(), exception.getMessage(), exception.getParams());
    return ResponseEntity.status(exception.getStatus()).body(body);
  }

}
