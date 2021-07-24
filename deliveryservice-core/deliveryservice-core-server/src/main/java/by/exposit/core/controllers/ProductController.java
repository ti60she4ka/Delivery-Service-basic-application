package by.exposit.core.controllers;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Product;
import by.exposit.core.services.product.ProductService;
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

  public void deleteById(Long id) throws EntityNotFoundException {
    productService.deleteById(id);
  }

  public Product getById(Long id) throws EntityNotFoundException {
    return productService.getById(id);
  }
}
