package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Category extends BaseEntity {
    String name;
    List<Category> subcategories;

    @Override
    public String toString() {
        return name;
    }
}
