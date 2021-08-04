package by.exposit.web.mappers;

import by.exposit.core.dto.ShopDto;
import by.exposit.web.requests.ShopRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopRequestMapper {

  ShopDto toDto(ShopRequest shopRequest);

  ShopDto toDtoWithId(ShopRequest shopRequest, Long id);
}
