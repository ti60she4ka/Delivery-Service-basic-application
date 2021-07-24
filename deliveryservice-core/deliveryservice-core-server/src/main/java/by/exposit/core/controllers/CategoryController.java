package by.exposit.core.controllers;

import by.exposit.core.model.entities.Category;
import by.exposit.core.services.category.CategoryService;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import java.util.Collection;

public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  public void create(Category category) throws EntityCannotBeAddedException {
    categoryService.create(category);
  }

  public Collection<Category> getAll() {
    return categoryService.getAll();
  }

  public void deleteById(Long id) throws EntityNotFoundException {
    categoryService.deleteById(id);
  }

  public Category getById(Long id) throws EntityNotFoundException {
    return categoryService.getById(id);
  }
}
