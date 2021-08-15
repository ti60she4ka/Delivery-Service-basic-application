package by.exposit.core.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Category extends BaseEntity {

  private String name;
  private Category parentCategory;
  private Long version;
}
