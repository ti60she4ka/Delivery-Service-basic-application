package by.exposit.services.category;

import by.exposit.model.entities.Category;
import by.exposit.repositories.category.CategoryRepository;
import by.exposit.services.AbstractServiceImpl;

public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    super(categoryRepository);
    this.categoryRepository = categoryRepository;
  }
}
