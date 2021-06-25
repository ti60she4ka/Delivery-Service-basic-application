package model.enums;

import lombok.Getter;

public enum Category {
    MEAT("Meat"),
    FISH("Fish"),
    FRUIT("Fruit"),
    VEGETABLES("Vegetables"),
    BEVERAGES("Beverages"),
    HOUSEHOLD_GOODS("Household goods"),
    COSMETICS("Cosmetics"),
    SPORT("Sport");

    @Getter
    private final String name;

    Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
