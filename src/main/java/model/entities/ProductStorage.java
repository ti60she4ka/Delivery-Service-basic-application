package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductStorage {
    private Product product;
    private int quantity;

    public ProductStorage(ProductStorage productStorage){
        this.product = new Product(productStorage.getProduct());
        this.quantity = productStorage.getQuantity();
    }

    @Override
    public String toString() {
        return product.getName() + " (Quantity = " + quantity + ", Price = " + product.getPrice() + ')';
    }
}
