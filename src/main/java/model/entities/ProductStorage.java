package model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStorage {
    private Product product;
    private int quantity;

    public ProductStorage(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " (Quantity = " + quantity + ", Price = " + product.getPrice() + ')';
    }
}
