package model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String name;
    private Collection<Category> categories;
    private Collection<Attribute> attributes;

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCategories:" + categoriesToString() +
                "\nAttributes:" + attributesToString();
    }

    private String categoriesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("\n\t— ").append(category.toString());
        }

        return stringBuilder.toString();
    }

    private String attributesToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Attribute attribute : attributes) {
            stringBuilder.append("\n\t— ").append(attribute.getName()).append(": ").append(attribute.getValue());
        }

        return stringBuilder.toString();
    }

}
