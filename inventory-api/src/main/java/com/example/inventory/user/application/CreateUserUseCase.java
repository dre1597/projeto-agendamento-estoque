package com.example.inventory.user.application;

import com.example.inventory.common.domain.DomainException;
import com.example.inventory.user.domain.User;
import com.example.inventory.user.domain.UserErrorCode;
import com.example.inventory.user.domain.UserRepository;
import com.example.inventory.user.domain.UserStatus;
import java.util.Map;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

  private static final int USERNAME_MIN = 3;
  private static final int USERNAME_MAX = 20;
  private static final String USERNAME_PATTERN = "[a-z0-9.]";
  private static final int PASSWORD_MIN = 8;
  private static final String ALLOWED_SYMBOLS = "!@#$%&*()-_=+.,;:?/";

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public CreateUserUseCase(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Output execute(Input input) {
    var username = input.username() == null ? null : input.username().toLowerCase();

    if (username != null && userRepository.existsByUsername(username)) {
      throw usernameAlreadyInUse();
    }
    if (username == null || username.length() < USERNAME_MIN || username.length() > USERNAME_MAX) {
      throw usernameLengthOutOfRange();
    }
    if (!hasOnlyAllowedUsernameChars(username)) {
      throw usernameInvalidCharacters();
    }
    validatePassword(input.password());

    var user = new User(
        username,
        passwordEncoder.encode(input.password()),
        input.mustChangePassword(),
        input.admin(),
        UserStatus.ACTIVE);

    var saved = save(user);

    return new Output(saved.getId(), saved.getUsername(), saved.getStatus().getValue(), saved.isAdmin());
  }

  private User save(User user) {
    try {
      return userRepository.save(user);
    } catch (DataIntegrityViolationException _) {
      throw usernameAlreadyInUse();
    }
  }

  private void validatePassword(String password) {
    if (password == null
        || password.length() < PASSWORD_MIN
        || !containsLetter(password)
        || !containsNumber(password)
        || !containsAllowedSymbol(password)
        || !hasOnlyAllowedPasswordChars(password)) {
      throw passwordRulesViolation();
    }
  }

  private boolean hasOnlyAllowedUsernameChars(String username) {
    return username.chars().allMatch(c -> isLetterOrDigit(c) || c == '.');
  }

  private boolean hasOnlyAllowedPasswordChars(String password) {
    return password.chars()
        .allMatch(c -> isLetterOrDigit(c) || ALLOWED_SYMBOLS.indexOf(c) >= 0);
  }

  private boolean containsLetter(String value) {
    return value.chars().anyMatch(CreateUserUseCase::isLetter);
  }

  private boolean containsNumber(String value) {
    return value.chars().anyMatch(c -> c >= '0' && c <= '9');
  }

  private boolean containsAllowedSymbol(String value) {
    return value.chars().anyMatch(c -> ALLOWED_SYMBOLS.indexOf(c) >= 0);
  }

  private static boolean isLetterOrDigit(int c) {
    return isLetter(c) || (c >= '0' && c <= '9');
  }

  private static boolean isLetter(int c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private DomainException usernameAlreadyInUse() {
    return new DomainException(
        UserErrorCode.USERNAME_ALREADY_IN_USE.getCode(),
        HttpStatus.CONFLICT,
        "Username is already in use");
  }

  private DomainException usernameLengthOutOfRange() {
    return new DomainException(
        UserErrorCode.USERNAME_LENGTH_OUT_OF_RANGE.getCode(),
        HttpStatus.BAD_REQUEST,
        "Username must be between 3 and 20 characters",
        Map.of("min", USERNAME_MIN, "max", USERNAME_MAX));
  }

  private DomainException usernameInvalidCharacters() {
    return new DomainException(
        UserErrorCode.USERNAME_INVALID_CHARACTERS.getCode(),
        HttpStatus.BAD_REQUEST,
        "Username may contain only letters, numbers and dot",
        Map.of("pattern", USERNAME_PATTERN));
  }

  private DomainException passwordRulesViolation() {
    return new DomainException(
        UserErrorCode.PASSWORD_RULES_VIOLATION.getCode(),
        HttpStatus.BAD_REQUEST,
        "Password must be at least 8 characters and contain letters, numbers and symbols",
        Map.of(
            "minLength", PASSWORD_MIN,
            "minLetters", 1,
            "minNumbers", 1,
            "minSymbols", 1,
            "allowedSymbols", ALLOWED_SYMBOLS));
  }

  public record Input(String username, String password, boolean mustChangePassword, boolean admin) {
  }

  public record Output(Long id, String username, String status, boolean admin) {
  }

}
