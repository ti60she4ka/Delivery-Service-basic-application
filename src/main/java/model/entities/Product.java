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
    private List<Category> categories;
    private Map<String, String> features;

    public Product(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.categories = new ArrayList<>(product.getCategories());
        this.features = new HashMap<>(product.getFeatures());
    }

    @Override
    public String toString() {
        return "ID — " + id +
                "\nName — " + name +
                "\nCategories:" + categoriesToString() +
                "\nFeatures:" + featuresToString();
    }

    private String categoriesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Category category : categories) {
            stringBuilder.append("\n\t— ").append(category.toString());
        }

        return stringBuilder.toString();
    }

    private String featuresToString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : features.entrySet()) {
            stringBuilder.append("\n\t— ").append(entry.getKey()).append(": ").append(entry.getValue());
        }

        return stringBuilder.toString();
    }

}
