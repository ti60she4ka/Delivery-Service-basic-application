package by.exposit.core.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class OrderItem {

  private Article article;
  private Integer quantity;
  private Double price;
}
