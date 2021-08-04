package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAlreadyExistsException extends EntityAlreadyExistsException {

  private final String username;

  @Override
  public String getMessage() {
    return "User with username = '" + username + "' already exists.";
  }
}
