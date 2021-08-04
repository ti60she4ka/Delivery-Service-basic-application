package by.exposit.persistence.repositories.product;

import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.persistence.entities.AttributeEntity;
import by.exposit.persistence.entities.ProductEntity;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import by.exposit.persistence.mappers.ProductPersistenceMapper;
import by.exposit.persistence.repositories.product.attribute.AttributeJpaRepository;
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
  public Product create(Product product) {
    ProductEntity productEntity = productMapper.toPersistenceEntity(product);

    for(AttributeEntity attribute : productEntity.getAttributes()){
      attribute.setProduct(productEntity);
    }

    return productMapper.toEntity(productRepository.save(productEntity));
  }

  @Override
  public Collection<Product> getAll() {
    return productMapper.toEntityCollection(productRepository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Product product) {
    attributeRepository.deleteAllByProductId(product.getId());
    ProductEntity productEntity = productMapper.toPersistenceEntity(product);

    for(AttributeEntity attribute : productEntity.getAttributes()){
      attribute.setProduct(productEntity);
    }

    productRepository.save(productEntity);
  }

  @Override
  public Product getById(Long id) {
    return productMapper.toEntity(productRepository.getById(id));
  }

  @Override
  public Collection<Article> getArticlesByProductId(Long id) {
    return articleMapper.toEntityCollection(productRepository.getById(id).getArticles());
  }

  @Override
  public boolean existsByName(String name) {
    return productRepository.existsByName(name);
  }

  @Override
  public boolean existsByNameAndIdIsNot(String name, Long id) {
    return productRepository.existsByNameAndIdIsNot(name, id);
  }

  @Override
  public boolean existsById(Long id) {
    return productRepository.existsById(id);
  }
}
