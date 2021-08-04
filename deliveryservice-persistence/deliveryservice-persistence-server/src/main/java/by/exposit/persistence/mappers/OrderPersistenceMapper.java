package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Order;
import by.exposit.persistence.entities.OrderEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemPersistenceMapper.class})
public interface OrderPersistenceMapper {

  OrderEntity toPersistenceEntity(Order order);

  Order toEntity(OrderEntity orderEntity);

  Collection<OrderEntity> toPersistenceEntityCollection(Collection<Order> orders);

  Collection<Order> toEntityCollection(Collection<OrderEntity> orderEntityCollection);
}
