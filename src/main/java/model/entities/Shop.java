package model.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop extends BaseEntity {
    private String name;
    private String city;

    public Shop(String name, String city){
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "ID — " + id + '\n'
                + "Name — " + name + '\n'
                + "City — " + city;
    }
}
