package com.example.inventory.common.domain;

import java.util.Map;
import org.springframework.http.HttpStatus;

public class DomainException extends RuntimeException {

  private final String code;
  private final HttpStatus status;
  private final Map<String, Object> params;

  public DomainException(String code, HttpStatus status, String message) {
    this(code, status, message, Map.of());
  }

  public DomainException(String code, HttpStatus status, String message, Map<String, Object> params) {
    super(message);
    this.code = code;
    this.status = status;
    this.params = params;
  }

  public String getCode() {
    return code;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public Map<String, Object> getParams() {
    return params;
  }

}
