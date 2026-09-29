package com.example.inventory.user.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Test
  void rejectsDuplicateUsername() {
    userRepository.saveAndFlush(new User("admin", "hash", false, false, UserStatus.ACTIVE));

    assertThatThrownBy(
            () -> userRepository.saveAndFlush(new User("admin", "hash", false, false, UserStatus.ACTIVE)))
        .isInstanceOf(DataAccessException.class);
  }

  @Test
  void persistsStatusAsLowercaseValueAndReadsItBack() {
    var saved =
        userRepository.saveAndFlush(new User("john", "hash", false, false, UserStatus.ACTIVE));

    var storedStatus = jdbcTemplate.queryForObject(
        "select status from users where id = ?", String.class, saved.getId());
    assertThat(storedStatus).isEqualTo("active");

    var loaded = userRepository.findById(saved.getId()).orElseThrow();
    assertThat(loaded.getStatus()).isEqualTo(UserStatus.ACTIVE);
  }

}
