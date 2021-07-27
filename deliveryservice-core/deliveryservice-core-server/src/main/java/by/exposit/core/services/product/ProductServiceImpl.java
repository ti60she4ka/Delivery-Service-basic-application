package by.exposit.core.services.product;

import by.exposit.core.dto.ProductDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.product.ProductRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductDto> implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository, BaseMapper<Product, ProductDto> mapper) {
    super(productRepository, mapper);
    this.productRepository = productRepository;
  }
}
