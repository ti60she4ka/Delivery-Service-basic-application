package by.exposit.core.services.category;

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
    entityType = "Category";
  }

  @Override
  public CategoryDto create(CategoryDto categoryDto) {
    if (!categoryRepository.existsByName(categoryDto.getName())) {
      return mapper.toDto(categoryRepository.create(mapToCategory(categoryDto)));
    } else {
      throw new CategoryAlreadyExistsException(categoryDto.getName());
    }
  }

  @Override
  public void deleteById(Long id) {
    if (categoryRepository.existsById(id)) {
      super.deleteById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public void update(CategoryDto categoryDto) {
    if (!categoryRepository.existsByNameAndIdIsNot(categoryDto.getName(), categoryDto.getId())) {
      categoryRepository.update(mapToCategory(categoryDto));
    } else {
      throw new CategoryAlreadyExistsException(categoryDto.getName());
    }
  }

  @Override
  public CategoryDto getById(Long id) {
    if (categoryRepository.existsById(id)) {
      return super.getById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public Collection<ProductDto> getProductsByCategoryId(Long id) {
    if (categoryRepository.existsById(id)) {
      return productMapper.toDtoCollection(categoryRepository.getProductsByCategoryId(id));
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
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
      throw new EntityNotFoundException(entityType, parentId);
    }

    return category;
  }
}
