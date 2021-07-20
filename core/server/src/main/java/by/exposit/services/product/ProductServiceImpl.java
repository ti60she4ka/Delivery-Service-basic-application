package by.exposit.services.product;

import by.exposit.model.entities.Product;
import by.exposit.repositories.product.ProductRepository;
import by.exposit.services.AbstractServiceImpl;

public class ProductServiceImpl extends AbstractServiceImpl<Product> implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    super(productRepository);
    this.productRepository = productRepository;
  }
}
