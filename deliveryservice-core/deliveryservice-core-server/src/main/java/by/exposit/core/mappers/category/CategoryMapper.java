package by.exposit.core.mappers.category;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Category;
import by.exposit.core.repositories.category.CategoryRepository;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper implements BaseMapper<Category, CategoryDto> {

  @Autowired
  protected CategoryRepository categoryRepository;

  @Override
  @Mapping(target = "parentId", source = "parentCategory.id")
  public abstract CategoryDto toDto(Category category);

  @Override
  @Mapping(target = "parentCategory", source = "parentId", qualifiedByName = "parentIdToParentCategory")
  public abstract Category toEntity(CategoryDto categoryDto);

  @Override
  public abstract Collection<CategoryDto> toDtoCollection(Collection<Category> categoryCollection);

  @Override
  public abstract Collection<Category> toEntityCollection(Collection<CategoryDto> categoryDtoCollection);

  @Named("parentIdToParentCategory")
  public Category parentIdToParentCategory(Long parentId) {
    if (parentId == null) {
      return null;
    }

    return categoryRepository.getById(parentId);
  }
}
