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
    private Collection<AttributeValue<?>> attributeValues;

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCategories:" + categoriesToString() +
                "\nAttributes:" + attributesToString();
    }

    private String categoriesToString() {
        if (categories == null || categories.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("\n\t— ").append(category.toString());
        }

        return stringBuilder.toString();
    }

    private String attributesToString() {
        if (attributeValues == null || attributeValues.isEmpty()) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (AttributeValue<?> attributeValue : attributeValues) {
            stringBuilder.append("\n\t— ").append(attributeValue.getAttribute().getName())
                    .append(": ").append(attributeValue.getAttribute().getType().cast(attributeValue.getValue()));
        }

        return stringBuilder.toString();
    }

}
