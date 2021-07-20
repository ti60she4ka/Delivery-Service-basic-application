package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Product;
import by.exposit.services.product.ProductService;
import java.util.Collection;

public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  public void create(Product product) throws EntityCannotBeAddedException {
    productService.create(product);
  }

  public Collection<Product> getAll() {
    return productService.getAll();
  }

  public void deleteById(long id) throws EntityNotFoundException {
    productService.deleteById(id);
  }

  public Product getById(long id) throws EntityNotFoundException {
    return productService.getById(id);
  }
}
