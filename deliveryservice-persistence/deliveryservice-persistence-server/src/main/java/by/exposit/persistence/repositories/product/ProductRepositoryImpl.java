package by.exposit.persistence.repositories.product;

import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import by.exposit.persistence.mappers.ProductPersistenceMapper;
import by.exposit.persistence.repositories.product.attribute.AttributeJpaRepository;
import by.exposit.persistence.specifications.ProductSpecification;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

public class ProductRepositoryImpl implements ProductRepository {

  private final ProductJpaRepository productRepository;
  private final AttributeJpaRepository attributeRepository;
  private final ProductPersistenceMapper productMapper;
  private final ArticlePersistenceMapper articleMapper;

  public ProductRepositoryImpl(ProductJpaRepository productRepository,
      AttributeJpaRepository attributeRepository, ProductPersistenceMapper productMapper,
      ArticlePersistenceMapper articleMapper) {

    this.productRepository = productRepository;
    this.attributeRepository = attributeRepository;
    this.productMapper = productMapper;
    this.articleMapper = articleMapper;
  }

  @Override
  @Transactional
  public Product create(Product product) {
    return productMapper.toEntity(productRepository.save(productMapper.toPersistenceEntity(product)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Product> getAll() {
    return productMapper.toEntityCollection(productRepository.findAll());
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Product> getAll(ProductSpecificationFilter filter) {
    return productMapper.toEntityCollection(productRepository.findAll(ProductSpecification.filter(filter)));
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Product product) {
    attributeRepository.deleteAllByProductId(product.getId());

    productRepository.save(productMapper.toPersistenceEntity(product));
  }

  @Override
  @Transactional(readOnly = true)
  public Product getById(Long id) {
    return productMapper.toEntity(productRepository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Article> getArticlesByProductId(Long id) {
    return articleMapper.toEntityCollection(productRepository.getById(id).getArticles());
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByName(String name) {
    return productRepository.existsByName(name);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByNameAndIdIsNot(String name, Long id) {
    return productRepository.existsByNameAndIdIsNot(name, id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return productRepository.existsById(id);
  }
}
