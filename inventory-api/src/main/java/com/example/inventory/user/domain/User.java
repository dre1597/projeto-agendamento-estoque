package com.example.inventory.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String passwordHash;

  @Column(nullable = false)
  private boolean mustChangePassword;

  @Column(nullable = false)
  private boolean admin;

  @Convert(converter = UserStatusConverter.class)
  @Column(nullable = false)
  private UserStatus status;

  protected User() {
  }

  public User(
      String username,
      String passwordHash,
      boolean mustChangePassword,
      boolean admin,
      UserStatus status) {
    this.username = username;
    this.passwordHash = passwordHash;
    this.mustChangePassword = mustChangePassword;
    this.admin = admin;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPasswordHash() {
    return passwordHash;
  }

  public boolean isMustChangePassword() {
    return mustChangePassword;
  }

  public boolean isAdmin() {
    return admin;
  }

  public UserStatus getStatus() {
    return status;
  }

}
