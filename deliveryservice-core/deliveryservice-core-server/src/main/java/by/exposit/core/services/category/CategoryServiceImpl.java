package by.exposit.core.services.category;

import by.exposit.core.model.entities.Category;
import by.exposit.core.repositories.category.CategoryRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class CategoryServiceImpl extends AbstractServiceImpl<Category> implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository) {
    super(categoryRepository);
    this.categoryRepository = categoryRepository;
  }
}
