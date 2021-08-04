package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductAlreadyExistsException extends EntityAlreadyExistsException {

  private final String name;

  @Override
  public String getMessage() {
    return "Product with name = '" + name + "' already exists.";
  }
}
