package by.exposit.core.filter.specifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecificationFilter {

  private String name;
  private AttributeSpecificationFilter attribute;
}
