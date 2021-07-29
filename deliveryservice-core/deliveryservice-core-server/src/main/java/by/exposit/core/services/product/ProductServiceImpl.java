package by.exposit.core.services.product;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Category;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.category.CategoryRepository;
import by.exposit.core.repositories.product.ProductRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.ArrayList;
import java.util.Collection;

public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductDto> implements ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductServiceImpl(ProductRepository productRepository,
      CategoryRepository categoryRepository, BaseMapper<Product, ProductDto> mapper) {

    super(productRepository, mapper);
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    return mapper.toDto(productRepository.create(mapToProduct(productDto)));
  }

  @Override
  public void update(ProductDto productDto) {
    productRepository.update(mapToProduct(productDto));
  }

  private Product mapToProduct(ProductDto productDto){
    Product product = mapper.toEntity(productDto);

    Collection<CategoryDto> categoriesDto = productDto.getCategories();
    Collection<Category> categories = new ArrayList<>();

    for (CategoryDto categoryDto : categoriesDto){
      categories.add(categoryRepository.getById(categoryDto.getId()));
    }
    product.setCategories(categories);

    return product;
  }
}
