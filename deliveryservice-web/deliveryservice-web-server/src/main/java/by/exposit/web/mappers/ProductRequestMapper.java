package by.exposit.web.mappers;

import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.ProductDto;
import by.exposit.core.services.category.CategoryService;
import by.exposit.web.requests.ProductRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

  @Mapping(target = "categories", source = "categoryIdCollection", qualifiedByName = "idCollectionToCategories")
  ProductDto toDto(ProductRequest productRequest);

  @Mapping(target = "categories", source = "productRequest.categoryIdCollection", qualifiedByName = "idCollectionToCategories")
  ProductDto toDtoWithId(ProductRequest productRequest, Long id);

  @Named("idCollectionToCategories")
  default Collection<CategoryDto> idCollectionToCategories(Collection<Long> idCollection){
    if(idCollection == null){
      return new ArrayList<>();
    }

    List<CategoryDto> categories = new ArrayList<>();

    for(Long id : idCollection){
      CategoryDto categoryDto = new CategoryDto();
      categoryDto.setId(id);
      categories.add(categoryDto);
    }

    return categories;
  }
}
