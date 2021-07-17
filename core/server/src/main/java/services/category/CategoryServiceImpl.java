package services.category;

import repositories.category.CategoryRepository;
import services.AbstractServiceImpl;
import model.entities.Category;

public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements CategoryService {
    private static CategoryServiceImpl instance;
    private CategoryRepository categoryRepository;

    private CategoryServiceImpl(){
    }

    public static CategoryServiceImpl getInstance(){
        if(instance == null){
            instance = new CategoryServiceImpl();
        }

        return instance;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        abstractRepository = categoryRepository;
    }
}