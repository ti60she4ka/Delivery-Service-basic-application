package by.exposit.core.mappers.category;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Category;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {

  CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

  @Override
  @Mapping(target = "parentId", source = "parentCategory.id")
  CategoryDto toDto(Category category);

  @Override
  Category toEntity(CategoryDto categoryDto);

  @Override
  Collection<CategoryDto> toDtoCollection(Collection<Category> categoryCollection);

  @Override
  Collection<Category> toEntityCollection(Collection<CategoryDto> categoryDtoCollection);
}
