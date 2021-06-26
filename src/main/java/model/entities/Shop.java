package model.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Shop extends BaseEntity {
    private String name;
    private String city;
    private List<ProductStorage> productStorages;

    public Shop(String name, String city) {
        this.name = name;
        this.city = city;
        productStorages = new ArrayList<>();
    }

    public Shop(Shop shop){
        this.name = shop.getName();
        this.city = shop.getCity();
        this.productStorages = cloneProductStorages(shop.getProductStorages());
    }

    private List<ProductStorage> cloneProductStorages(List<ProductStorage> productStorages){
        List<ProductStorage> clone = new ArrayList<>();
        for(ProductStorage item : productStorages){
            clone.add(new ProductStorage(item));
        }

        return clone;
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCity — " + city;
    }
}
