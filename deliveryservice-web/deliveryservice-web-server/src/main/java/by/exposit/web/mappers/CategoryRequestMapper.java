package by.exposit.web.mappers;

import by.exposit.core.dto.CategoryDto;
import by.exposit.web.requests.CategoryRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryRequestMapper {

  CategoryDto toDto(CategoryRequest categoryRequest);

  CategoryDto toDtoWithId(CategoryRequest categoryRequest, Long id);
}
