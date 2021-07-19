package controllers;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import java.util.Collection;
import lombok.Setter;
import model.entities.Category;
import services.category.CategoryService;

public class CategoryController {

  private static CategoryController instance;
  @Setter
  private CategoryService categoryService;

  private CategoryController() {
  }

  public static CategoryController getInstance() {
    if (instance == null) {
      instance = new CategoryController();
    }

    return instance;
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
