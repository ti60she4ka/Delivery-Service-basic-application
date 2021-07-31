package by.exposit.core.model.entities;

import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {

  private String name;
  private Collection<Category> categories;
  private Collection<Attribute> attributes;
}
