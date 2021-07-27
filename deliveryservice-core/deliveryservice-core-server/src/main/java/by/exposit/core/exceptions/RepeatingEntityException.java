package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RepeatingEntityException extends RuntimeException {

  private final String entityType;
  private final Long id;

  @Override
  public String getMessage() {
    return entityType + " with ID = " + id + " is repeated.";
  }
}
