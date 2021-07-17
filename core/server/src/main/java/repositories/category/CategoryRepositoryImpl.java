package repositories.category;

import repositories.AbstractRepositoryImpl;
import model.entities.Category;
import storages.CategoryDataStorage;

public class CategoryRepositoryImpl extends AbstractRepositoryImpl<Category> implements CategoryRepository {
    private static CategoryRepositoryImpl instance;
    private CategoryDataStorage categoryDataStorage;

    private CategoryRepositoryImpl() {
    }

    public static CategoryRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CategoryRepositoryImpl();
        }

        return instance;
    }

    public void setCategoryDataStorage(CategoryDataStorage categoryDataStorage) {
        this.categoryDataStorage = categoryDataStorage;
        abstractDataStorage = categoryDataStorage;
        entityType = "Category";
    }
}
