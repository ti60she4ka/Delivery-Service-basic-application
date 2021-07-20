package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Category;
import by.exposit.services.category.CategoryService;
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

  public void deleteById(long id) throws EntityNotFoundException {
    categoryService.deleteById(id);
  }

  public Category getById(long id) throws EntityNotFoundException {
    return categoryService.getById(id);
  }
}
