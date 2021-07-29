package by.exposit.core.mappers.order;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Order;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  @Override
  OrderDto toDto(Order order);

  @Override
  Order toEntity(OrderDto orderDto);

  @Override
  Collection<OrderDto> toDtoCollection(Collection<Order> orderCollection);

  @Override
  Collection<Order> toEntityCollection(Collection<OrderDto> orderDtoCollection);
}
