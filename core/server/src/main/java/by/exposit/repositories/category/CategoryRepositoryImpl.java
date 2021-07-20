package by.exposit.repositories.category;

import by.exposit.model.entities.Category;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.CategoryDataStorage;

public class CategoryRepositoryImpl extends AbstractRepositoryImpl<Category>
    implements CategoryRepository {

  private final CategoryDataStorage categoryDataStorage;

  public CategoryRepositoryImpl(CategoryDataStorage categoryDataStorage) {
    super(categoryDataStorage);
    this.categoryDataStorage = categoryDataStorage;
    entityType = "Category";
  }
}
