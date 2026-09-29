package com.example.inventory.user.domain;

public enum UserErrorCode {
  USERNAME_ALREADY_IN_USE("USERNAME_ALREADY_IN_USE"),
  USERNAME_LENGTH_OUT_OF_RANGE("USERNAME_LENGTH_OUT_OF_RANGE"),
  USERNAME_INVALID_CHARACTERS("USERNAME_INVALID_CHARACTERS"),
  PASSWORD_RULES_VIOLATION("PASSWORD_RULES_VIOLATION");

  private final String code;

  UserErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

}
