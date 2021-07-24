package by.exposit.core.repositories.category;

import by.exposit.core.model.entities.Category;
import by.exposit.core.repositories.AbstractRepositoryImpl;
import by.exposit.core.storages.CategoryDataStorage;

public class CategoryRepositoryImpl extends AbstractRepositoryImpl<Category>
    implements CategoryRepository {

  private final CategoryDataStorage categoryDataStorage;

  public CategoryRepositoryImpl(CategoryDataStorage categoryDataStorage) {
    super(categoryDataStorage);
    this.categoryDataStorage = categoryDataStorage;
    entityType = "Category";
  }
}
