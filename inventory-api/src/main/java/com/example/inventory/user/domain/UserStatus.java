package com.example.inventory.user.domain;

public enum UserStatus {
  ACTIVE("active"),
  INACTIVE("inactive"),
  BLOCKED("blocked");

  private final String value;

  UserStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static UserStatus fromValue(String value) {
    for (UserStatus status : values()) {
      if (status.value.equals(value)) {
        return status;
      }
    }
    throw new IllegalArgumentException("Unknown UserStatus value: " + value);
  }

}
