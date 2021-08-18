package by.exposit.core.services.category;

import by.exposit.core.annotations.category.CategoryIdExists;
import by.exposit.core.annotations.category.CategoryNameNotOccupied;
import by.exposit.core.aspects.validation.Validate;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.exceptions.CategoryAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.product.ProductMapper;
import by.exposit.core.model.entities.Category;
import by.exposit.core.repositories.CategoryRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.Collection;

public class CategoryServiceImpl extends AbstractServiceImpl<Category, CategoryDto> implements
    CategoryService {

  private final CategoryRepository categoryRepository;
  private final ProductMapper productMapper;

  public CategoryServiceImpl(CategoryRepository categoryRepository,
      BaseMapper<Category, CategoryDto> categoryMapper, ProductMapper productMapper) {
    super(categoryRepository, categoryMapper);
    this.categoryRepository = categoryRepository;
    this.productMapper = productMapper;
  }

  @Override
  @Validate
  public CategoryDto create(@CategoryNameNotOccupied CategoryDto categoryDto) {
    return mapper.toDto(categoryRepository.create(mapToCategory(categoryDto)));
  }

  @Override
  @Validate
  public void deleteById(@CategoryIdExists Long id) {
    super.deleteById(id);
  }

  @Override
  @Validate
  public void update(@CategoryNameNotOccupied CategoryDto categoryDto) {
    Category category = mapToCategory(categoryDto);
    category.setVersion(getVersionByCategoryId(categoryDto.getId()));
    categoryRepository.update(category);
  }

  @Override
  @Validate
  public CategoryDto getById(@CategoryIdExists Long id) {
    return super.getById(id);
  }

  @Override
  @Validate
  public Collection<ProductDto> getProductsByCategoryId(@CategoryIdExists Long id) {
    return productMapper.toDtoCollection(categoryRepository.getProductsByCategoryId(id));
  }

  private Category mapToCategory(CategoryDto categoryDto) {
    Category category = mapper.toEntity(categoryDto);
    Long parentId = categoryDto.getParentId();

    if (parentId == null) {
      return category;
    }

    if (categoryRepository.existsById(parentId)) {
      category.setParentCategory(categoryRepository.getById(parentId));
    } else {
      throw new EntityNotFoundException("Category", parentId);
    }

    return category;
  }

  private Long getVersionByCategoryId(Long id) {
    if (categoryRepository.existsById(id)) {
      return categoryRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
