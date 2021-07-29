package by.exposit.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryCannotBeAddedException extends EntityCannotBeAddedException {

  private final String name;

  @Override
  public String getMessage() {
    return "Category with name = '" + name + "' already exists.";
  }
}
