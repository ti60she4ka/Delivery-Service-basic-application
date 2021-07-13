package model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Article {
    private Product product;
    private Shop shop;
    private double price;
    private int amount;

    @Override
    public String toString() {
        return product.getName() + " (Price = " + price + ", Amount = " + amount + ") in " + shop.getName();
    }
}
