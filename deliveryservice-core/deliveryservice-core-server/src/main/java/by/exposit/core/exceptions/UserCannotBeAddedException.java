package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCannotBeAddedException extends EntityCannotBeAddedException {

  private final String email;

  @Override
  public String getMessage() {
    return "User with email = " + email + " already exists.\n";
  }
}
