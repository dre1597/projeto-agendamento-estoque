package com.example.inventory.user.web;

import com.example.inventory.user.application.CreateUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  private final CreateUserUseCase createUserUseCase;

  public UserController(CreateUserUseCase createUserUseCase) {
    this.createUserUseCase = createUserUseCase;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateUserResponse create(@RequestBody CreateUserRequest request) {
    var input = new CreateUserUseCase.Input(
        request.username(),
        request.password(),
        Boolean.TRUE.equals(request.mustChangePassword()),
        Boolean.TRUE.equals(request.admin())
    );

    var output = createUserUseCase.execute(input);

    return new CreateUserResponse(
        output.id(),
        output.username(),
        output.status(),
        output.admin());
  }

  public record CreateUserRequest(
      String username,
      String password,
      Boolean mustChangePassword,
      Boolean admin) {
  }

  public record CreateUserResponse(Long id, String username, String status, boolean admin) {
  }

}
