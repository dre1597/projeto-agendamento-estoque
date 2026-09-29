package com.example.inventory.user.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.inventory.common.domain.DomainException;
import com.example.inventory.user.application.CreateUserUseCase;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private CreateUserUseCase createUserUseCase;

  @Test
  void createsUserWithoutExposingPassword() throws Exception {
    when(createUserUseCase.execute(any()))
        .thenReturn(new CreateUserUseCase.Output(1L, "john", "active", true));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"John","password":"Abcdef1!","mustChangePassword":true,"admin":true}
                """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.username").value("john"))
        .andExpect(jsonPath("$.status").value("active"))
        .andExpect(jsonPath("$.admin").value(true))
        .andExpect(jsonPath("$.password").doesNotExist());
  }

  @Test
  void treatsMissingOptionalFlagsAsFalse() throws Exception {
    when(createUserUseCase.execute(any()))
        .thenReturn(new CreateUserUseCase.Output(1L, "john", "active", false));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"john","password":"Abcdef1!"}
                """))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.admin").value(false));

    var captor =
        ArgumentCaptor.forClass(CreateUserUseCase.Input.class);
    verify(createUserUseCase).execute(captor.capture());
    assertThat(captor.getValue().mustChangePassword()).isFalse();
    assertThat(captor.getValue().admin()).isFalse();
  }

  @Test
  void returnsConflictWhenUsernameAlreadyInUse() throws Exception {
    when(createUserUseCase.execute(any())).thenThrow(new DomainException(
        "USERNAME_ALREADY_IN_USE", HttpStatus.CONFLICT, "Username is already in use"));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"admin","password":"Abcdef1!"}
                """))
        .andExpect(status().isConflict())
        .andExpect(jsonPath("$.code").value("USERNAME_ALREADY_IN_USE"))
        .andExpect(jsonPath("$.message").value("Username is already in use"));
  }

  @Test
  void returnsBadRequestWhenUsernameLengthOutOfRange() throws Exception {
    when(createUserUseCase.execute(any())).thenThrow(new DomainException(
        "USERNAME_LENGTH_OUT_OF_RANGE",
        HttpStatus.BAD_REQUEST,
        "Username must be between 3 and 20 characters",
        Map.of("min", 3, "max", 20)));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"ab","password":"Abcdef1!"}
                """))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("USERNAME_LENGTH_OUT_OF_RANGE"))
        .andExpect(jsonPath("$.params.min").value(3))
        .andExpect(jsonPath("$.params.max").value(20));
  }

  @Test
  void returnsBadRequestWhenUsernameHasInvalidCharacters() throws Exception {
    when(createUserUseCase.execute(any())).thenThrow(new DomainException(
        "USERNAME_INVALID_CHARACTERS",
        HttpStatus.BAD_REQUEST,
        "Username may contain only letters, numbers and dot",
        Map.of("pattern", "[a-z0-9.]")));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"john_doe","password":"Abcdef1!"}
                """))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("USERNAME_INVALID_CHARACTERS"))
        .andExpect(jsonPath("$.params.pattern").value("[a-z0-9.]"));
  }

  @Test
  void returnsBadRequestWhenPasswordRulesViolated() throws Exception {
    when(createUserUseCase.execute(any())).thenThrow(new DomainException(
        "PASSWORD_RULES_VIOLATION",
        HttpStatus.BAD_REQUEST,
        "Password must be at least 8 characters and contain letters, numbers and symbols",
        Map.of("minLength", 8)));

    mockMvc.perform(post("/api/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {"username":"john","password":"short"}
                """))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.code").value("PASSWORD_RULES_VIOLATION"))
        .andExpect(jsonPath("$.params.minLength").value(8));
  }

}
