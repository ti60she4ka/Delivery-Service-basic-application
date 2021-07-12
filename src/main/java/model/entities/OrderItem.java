package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderItem {
    private Article article;
    private int quantity;
    private int price;

    @Override
    public String toString() {
        return article.getProduct().getName() + " (Quantity = " + quantity + ", Price = " + price;
    }
}
