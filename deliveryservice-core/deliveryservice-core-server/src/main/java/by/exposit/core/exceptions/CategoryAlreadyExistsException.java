package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryAlreadyExistsException extends EntityAlreadyExistsException {

  private final String name;

  @Override
  public String getMessage() {
    return "Category with name = '" + name + "' already exists.";
  }
}
