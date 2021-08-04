package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Category;
import by.exposit.persistence.entities.CategoryEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryPersistenceMapper {

  CategoryEntity toPersistenceEntity(Category category);

  Category toEntity(CategoryEntity categoryEntity);

  Collection<CategoryEntity> toPersistenceEntityCollection(Collection<Category> categories);

  Collection<Category> toCategoryCollection(Collection<CategoryEntity> categoryEntityCollection);
}
