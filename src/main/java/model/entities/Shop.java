package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Shop extends BaseEntity {
    private String name;
    private String city;
    private String address;

    public Shop(Shop shop){
        this.name = shop.getName();
        this.city = shop.getCity();
        this.address = shop.getAddress();
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCity — " + city +
                "\nAddress — " + address;
    }
}
