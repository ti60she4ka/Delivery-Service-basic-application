package by.exposit.core.services.product;

import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.product.ProductRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    super(productRepository);
    this.productRepository = productRepository;
  }
}