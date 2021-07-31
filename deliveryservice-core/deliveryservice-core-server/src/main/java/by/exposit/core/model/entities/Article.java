package by.exposit.core.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Article extends BaseEntity {

  private Product product;
  private Shop shop;
  private Double price;
  private Integer amount;
}
