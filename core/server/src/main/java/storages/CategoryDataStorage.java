package storages;

import lombok.Setter;
import model.entities.Category;

public class CategoryDataStorage extends AbstractDataStorage<Category> {
    @Setter
    private static CategoryDataStorage instance;

    private CategoryDataStorage(){}

    public static CategoryDataStorage getInstance(){
        if(instance == null){
            instance = new CategoryDataStorage();
        }

        return instance;
    }
}
