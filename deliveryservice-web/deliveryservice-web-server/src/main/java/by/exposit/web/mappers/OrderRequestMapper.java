package by.exposit.web.mappers;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.UserDto;
import by.exposit.web.requests.OrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {OrderItemRequestMapper.class})
public interface OrderRequestMapper {

  @Mapping(target = "user", source = "userId", qualifiedByName = "userIdToUser")
  OrderDto toDto(OrderRequest orderRequest);

  @Mapping(target = "user", source = "orderRequest.userId", qualifiedByName = "userIdToUser")
  OrderDto toDtoWithId(OrderRequest orderRequest, Long id);

  @Named("userIdToUser")
  default UserDto userIdToUser(Long userId){
    UserDto userDto = new UserDto();
    userDto.setId(userId);
    return userDto;
  }
}
