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

    public Product(String name, EnumSet<Category> categories){
        this.name = name;
        this.categories = categories;
    }

    public Product(Product product){
        name = product.name;
        categories = EnumSet.copyOf(product.categories);
    }

    @Override
    public String toString() {
        return "ID — " + id + '\n'
                + "Name — " + name + '\n'
                + "Categories:" + categoriesToString();
    }

    private String categoriesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Category category : categories){
            stringBuilder.append('\n').append("\t— ").append(category.toString());
        }

        return stringBuilder.toString();
    }
}
