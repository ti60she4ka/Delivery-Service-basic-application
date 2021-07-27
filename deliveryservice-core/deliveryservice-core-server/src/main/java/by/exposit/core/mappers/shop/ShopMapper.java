package by.exposit.core.mappers.shop;

import by.exposit.core.dto.ShopDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Shop;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper extends BaseMapper<Shop, ShopDto> {

  @Override
  ShopDto toDto(Shop shop);

  @Override
  Shop toEntity(ShopDto shopDto);

  @Override
  Collection<ShopDto> toDtoCollection(Collection<Shop> shopCollection);

  @Override
  Collection<Shop> toEntityCollection(Collection<ShopDto> shopDtoCollection);
}
