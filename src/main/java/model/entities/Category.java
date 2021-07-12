package model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Category extends BaseEntity {
    String name;
    Category parentCategory;

    @Override
    public String toString() {
        return name;
    }
}
