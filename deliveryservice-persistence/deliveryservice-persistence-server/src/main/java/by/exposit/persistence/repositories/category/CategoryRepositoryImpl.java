package by.exposit.persistence.repositories.category;

import by.exposit.core.model.entities.Category;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.persistence.mappers.CategoryPersistenceMapper;
import by.exposit.persistence.mappers.ProductPersistenceMapper;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

public class CategoryRepositoryImpl implements CategoryRepository {

  private final CategoryJpaRepository categoryRepository;
  private final CategoryPersistenceMapper categoryMapper;
  private final ProductPersistenceMapper productMapper;

  public CategoryRepositoryImpl(CategoryJpaRepository categoryRepository,
      CategoryPersistenceMapper categoryMapper, ProductPersistenceMapper productMapper) {
    this.categoryRepository = categoryRepository;
    this.categoryMapper = categoryMapper;
    this.productMapper = productMapper;
  }

  @Override
  @Transactional
  public Category create(Category category) {
    return categoryMapper.toEntity(categoryRepository.save(categoryMapper.toPersistenceEntity(category)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Category> getAll() {
    return categoryMapper.toCategoryCollection(categoryRepository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    categoryRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Category category) {
    categoryRepository.save(categoryMapper.toPersistenceEntity(category));
  }

  @Override
  @Transactional(readOnly = true)
  public Category getById(Long id) {
    return categoryMapper.toEntity(categoryRepository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Product> getProductsByCategoryId(Long id) {
    return productMapper.toEntityCollection(categoryRepository.getById(id).getProducts());
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByName(String name) {
    return categoryRepository.existsByName(name);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByNameAndIdIsNot(String name, Long id) {
    return categoryRepository.existsByNameAndIdIsNot(name, id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return categoryRepository.existsById(id);
  }
}
