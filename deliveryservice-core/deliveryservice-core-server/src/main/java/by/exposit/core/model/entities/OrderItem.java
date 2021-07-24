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
  private int quantity;
  private int price;

  @Override
  public String toString() {
    return article.getProduct().getName() + " (Quantity = " + quantity + ", Price = " + price;
  }
}
