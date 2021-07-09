package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    Product product;
    Shop shop;
    double price;
    int amount;

    @Override
    public String toString() {
        return product.getName() + " (Price = " + price + ", Amount = " + amount + ") in " + shop.getName();
    }
}
