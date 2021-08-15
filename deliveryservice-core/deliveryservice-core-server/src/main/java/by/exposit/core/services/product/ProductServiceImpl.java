package by.exposit.core.services.product;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.ProductAlreadyExistsException;
import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.article.ArticleMapper;
import by.exposit.core.model.entities.Category;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.ArrayList;
import java.util.Collection;

public class ProductServiceImpl extends AbstractServiceImpl<Product, ProductDto> implements
    ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final ArticleMapper articleMapper;

  public ProductServiceImpl(ProductRepository productRepository,
      CategoryRepository categoryRepository,
      BaseMapper<Product, ProductDto> productMapper, ArticleMapper articleMapper) {

    super(productRepository, productMapper);
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
    this.articleMapper = articleMapper;
    entityType = "Product";
  }

  @Override
  public ProductDto create(ProductDto productDto) {
    if (!productRepository.existsByName(productDto.getName())) {
      return mapper.toDto(productRepository.create(mapToProduct(productDto)));
    } else {
      throw new ProductAlreadyExistsException(productDto.getName());
    }
  }

  @Override
  public void deleteById(Long id) {
    if (productRepository.existsById(id)) {
      super.deleteById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public void update(ProductDto productDto) {
    if (!productRepository.existsByNameAndIdIsNot(productDto.getName(), productDto.getId())) {
      Product product = mapToProduct(productDto);
      product.setVersion(getVersionByProductId(productDto.getId()));
      productRepository.update(product);
    } else {
      throw new ProductAlreadyExistsException(productDto.getName());
    }
  }

  @Override
  public ProductDto getById(Long id) {
    if (productRepository.existsById(id)) {
      return super.getById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public Collection<ArticleDto> getArticlesByProductId(Long id) {
    if (productRepository.existsById(id)) {
      return articleMapper.toDtoCollection(productRepository.getArticlesByProductId(id));
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public Collection<ProductDto> getAll(ProductSpecificationFilter filter) {
    return mapper.toDtoCollection(productRepository.getAll(filter));
  }

  private Product mapToProduct(ProductDto productDto) {
    Product product = mapper.toEntity(productDto);

    Collection<CategoryDto> categoriesDto = productDto.getCategories();
    Collection<Category> categories = new ArrayList<>();

    for (CategoryDto categoryDto : categoriesDto) {
      if (categoryRepository.existsById(categoryDto.getId())) {
        categories.add(categoryRepository.getById(categoryDto.getId()));
      } else {
        throw new EntityNotFoundException("Category", categoryDto.getId());
      }
    }
    product.setCategories(categories);

    return product;
  }

  private Long getVersionByProductId(Long id) {
    if (productRepository.existsById(id)) {
      return productRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
