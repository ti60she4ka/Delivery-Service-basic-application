package by.exposit.core.services.category;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Category;
import by.exposit.core.repositories.category.CategoryRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class CategoryServiceImpl extends AbstractServiceImpl<Category, CategoryDto> implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryServiceImpl(CategoryRepository categoryRepository, BaseMapper<Category, CategoryDto> mapper) {
    super(categoryRepository, mapper);
    this.categoryRepository = categoryRepository;
  }
}
