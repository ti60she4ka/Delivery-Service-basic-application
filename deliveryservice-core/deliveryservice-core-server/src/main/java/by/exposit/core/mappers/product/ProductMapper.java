package by.exposit.core.mappers.product;

import by.exposit.core.dto.ProductDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.category.CategoryMapper;
import by.exposit.core.model.entities.Product;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper extends BaseMapper<Product, ProductDto> {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  @Override
  ProductDto toDto(Product product);

  @Override
  @Mapping(target = "categories", ignore = true)
  Product toEntity(ProductDto productDto);

  @Override
  Collection<ProductDto> toDtoCollection(Collection<Product> productCollection);

  @Override
  Collection<Product> toEntityCollection(Collection<ProductDto> productDtoCollection);
}
