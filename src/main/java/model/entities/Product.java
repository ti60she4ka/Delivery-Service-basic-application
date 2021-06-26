package model.entities;

import lombok.Getter;
import lombok.Setter;
import model.enums.Category;

import java.util.EnumSet;

@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private EnumSet<Category> categories;
    private double price;
    private String nameOfShop; // Name of the shop where the product is located

    public Product(String name, EnumSet<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

    public Product(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.categories = EnumSet.copyOf(product.getCategories());
        this.price = product.getPrice();
        this.nameOfShop = product.getNameOfShop();
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCategories:" + categoriesToString();
    }

    private String categoriesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("\n\t— ").append(category.toString());
        }

        return stringBuilder.toString();
    }
}
