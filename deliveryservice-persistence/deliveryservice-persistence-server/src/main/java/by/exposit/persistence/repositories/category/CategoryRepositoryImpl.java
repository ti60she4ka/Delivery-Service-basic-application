package by.exposit.persistence.repositories.category;

import by.exposit.core.model.entities.Category;
import by.exposit.core.model.entities.Product;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.persistence.mappers.CategoryPersistenceMapper;
import by.exposit.persistence.mappers.ProductPersistenceMapper;
import java.util.Collection;

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
  public Category create(Category category) {
    return categoryMapper.toEntity(categoryRepository.save(categoryMapper.toPersistenceEntity(category)));
  }

  @Override
  public Collection<Category> getAll() {
    return categoryMapper.toCategoryCollection(categoryRepository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    categoryRepository.findAllByParentCategoryId(id)
        .forEach(category -> category.setParentCategory(null));

    categoryRepository.getById(id).getProducts()
        .forEach(product -> product.getCategories().removeIf(category -> category.getId().equals(id)));

    categoryRepository.deleteById(id);
  }

  @Override
  public void update(Category category) {
    categoryRepository.save(categoryMapper.toPersistenceEntity(category));
  }

  @Override
  public Category getById(Long id) {
    return categoryMapper.toEntity(categoryRepository.getById(id));
  }

  @Override
  public Collection<Product> getProductsByCategoryId(Long id) {
    return productMapper.toEntityCollection(categoryRepository.getById(id).getProducts());
  }

  @Override
  public boolean existsByName(String name) {
    return categoryRepository.existsByName(name);
  }

  @Override
  public boolean existsByNameAndIdIsNot(String name, Long id) {
    return categoryRepository.existsByNameAndIdIsNot(name, id);
  }

  @Override
  public boolean existsById(Long id) {
    return categoryRepository.existsById(id);
  }
}
