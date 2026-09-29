package com.example.inventory.user.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.inventory.common.domain.DomainException;
import com.example.inventory.user.domain.User;
import com.example.inventory.user.domain.UserErrorCode;
import com.example.inventory.user.domain.UserRepository;
import com.example.inventory.user.domain.UserStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

class CreateUserUseCaseTest {

  private UserRepository userRepository;
  private CreateUserUseCase useCase;

  @BeforeEach
  void setUp() {
    userRepository = mock(UserRepository.class);
    useCase = new CreateUserUseCase(userRepository);
    when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
  }

  @Test
  void createsUserWithNormalizedUsernameActiveStatusAndHashedPassword() {
    when(userRepository.save(any(User.class))).thenAnswer(invocation -> {
      User user = invocation.getArgument(0);
      ReflectionTestUtils.setField(user, "id", 1L);
      return user;
    });

    var output =
        useCase.execute(new CreateUserUseCase.Input("John.Doe", "Abcdef1!", true, true));

    assertThat(output.id()).isEqualTo(1L);
    assertThat(output.username()).isEqualTo("john.doe");
    assertThat(output.status()).isEqualTo("active");
    assertThat(output.admin()).isTrue();

    var captor = ArgumentCaptor.forClass(User.class);
    verify(userRepository).save(captor.capture());
    var saved = captor.getValue();
    assertThat(saved.getUsername()).isEqualTo("john.doe");
    assertThat(saved.getStatus()).isEqualTo(UserStatus.ACTIVE);
    assertThat(saved.isMustChangePassword()).isTrue();
    assertThat(saved.getPasswordHash()).isNotEqualTo("Abcdef1!");
    assertThat(new BCryptPasswordEncoder().matches("Abcdef1!", saved.getPasswordHash())).isTrue();
  }

  @Test
  void rejectsDuplicateUsername() {
    when(userRepository.existsByUsername("admin")).thenReturn(true);

    assertCode(() -> useCase.execute(input("admin", "Abcdef1!")), UserErrorCode.USERNAME_ALREADY_IN_USE);
    verify(userRepository, never()).save(any());
  }

  @Test
  void rejectsDuplicateUsernameIgnoringCase() {
    when(userRepository.existsByUsername("admin")).thenReturn(true);

    assertCode(() -> useCase.execute(input("Admin", "Abcdef1!")), UserErrorCode.USERNAME_ALREADY_IN_USE);
  }

  @Test
  void mapsDataIntegrityViolationToUsernameAlreadyInUse() {
    when(userRepository.save(any(User.class)))
        .thenThrow(new DataIntegrityViolationException("duplicate"));

    assertCode(() -> useCase.execute(input("john", "Abcdef1!")), UserErrorCode.USERNAME_ALREADY_IN_USE);
  }

  @Test
  void acceptsUsernameWithThreeCharacters() {
    assertThat(useCase.execute(input("abc", "Abcdef1!")).username()).isEqualTo("abc");
  }

  @Test
  void acceptsUsernameWithTwentyCharacters() {
    var username = "abcdefghijklmnopqrst";
    assertThat(useCase.execute(input(username, "Abcdef1!")).username()).isEqualTo(username);
  }

  @Test
  void rejectsUsernameWithTwoCharacters() {
    assertCode(() -> useCase.execute(input("ab", "Abcdef1!")), UserErrorCode.USERNAME_LENGTH_OUT_OF_RANGE);
  }

  @Test
  void rejectsUsernameWithTwentyOneCharacters() {
    assertCode(
        () -> useCase.execute(input("abcdefghijklmnopqrstu", "Abcdef1!")),
        UserErrorCode.USERNAME_LENGTH_OUT_OF_RANGE);
  }

  @Test
  void rejectsUsernameWithInvalidCharacters() {
    for (String invalid : List.of("ab c", "ab_c", "ab-c", "ab@c", "ação")) {
      assertCode(
          () -> useCase.execute(input(invalid, "Abcdef1!")),
          UserErrorCode.USERNAME_INVALID_CHARACTERS);
    }
  }

  @Test
  void acceptsUsernameWithDot() {
    assertThat(useCase.execute(input("john.doe", "Abcdef1!")).username()).isEqualTo("john.doe");
  }

  @Test
  void rejectsNullUsernameWithLengthError() {
    assertCode(
        () -> useCase.execute(new CreateUserUseCase.Input(null, "Abcdef1!", false, false)),
        UserErrorCode.USERNAME_LENGTH_OUT_OF_RANGE);
  }

  @Test
  void rejectsEmptyUsernameWithLengthError() {
    assertCode(() -> useCase.execute(input("", "Abcdef1!")), UserErrorCode.USERNAME_LENGTH_OUT_OF_RANGE);
  }

  @Test
  void duplicateTakesPriorityOverInvalidLength() {
    when(userRepository.existsByUsername("ab")).thenReturn(true);

    assertCode(() -> useCase.execute(input("ab", "Abcdef1!")), UserErrorCode.USERNAME_ALREADY_IN_USE);
  }

  @Test
  void acceptsPasswordWithExactlyEightCharacters() {
    assertThat(useCase.execute(input("john", "Abcd123!")).username()).isEqualTo("john");
  }

  @Test
  void rejectsPasswordWithSevenCharacters() {
    assertCode(() -> useCase.execute(input("john", "Abc123!")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsPasswordWithoutLetter() {
    assertCode(() -> useCase.execute(input("john", "1234567!")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsPasswordWithoutNumber() {
    assertCode(() -> useCase.execute(input("john", "abcdefg!")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsPasswordWithoutSymbol() {
    assertCode(() -> useCase.execute(input("john", "abcdefg1")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsPasswordWithSymbolOutsideAllowedSet() {
    for (String invalid : List.of("Abcdef1\"", "Abcdef1\\", "Abcdef1<", "Abcdef1>")) {
      assertCode(
          () -> useCase.execute(input("john", invalid)),
          UserErrorCode.PASSWORD_RULES_VIOLATION);
    }
  }

  @Test
  void rejectsPasswordWithSpace() {
    assertCode(() -> useCase.execute(input("john", "Abcdef 1!")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsNullPassword() {
    assertCode(
        () -> useCase.execute(new CreateUserUseCase.Input("john", null, false, false)),
        UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  @Test
  void rejectsEmptyPassword() {
    assertCode(() -> useCase.execute(input("john", "")), UserErrorCode.PASSWORD_RULES_VIOLATION);
  }

  private CreateUserUseCase.Input input(String username, String password) {
    return new CreateUserUseCase.Input(username, password, false, false);
  }

  private void assertCode(Runnable action, UserErrorCode code) {
    assertThatThrownBy(action::run)
        .isInstanceOf(DomainException.class)
        .extracting(exception -> ((DomainException) exception).getCode())
        .isEqualTo(code.name());
  }

}
