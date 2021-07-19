package model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

  private String name;
  private Category parentCategory;

  @Override
  public String toString() {
    return name;
  }
}
