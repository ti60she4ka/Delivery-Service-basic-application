package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Order;
import by.exposit.persistence.entities.OrderEntity;
import by.exposit.persistence.entities.OrderItemEntity;
import java.util.Collection;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {OrderItemPersistenceMapper.class})
public interface OrderPersistenceMapper {

  OrderEntity toPersistenceEntity(Order order);

  Order toEntity(OrderEntity orderEntity);

  Collection<OrderEntity> toPersistenceEntityCollection(Collection<Order> orders);

  Collection<Order> toEntityCollection(Collection<OrderEntity> orderEntityCollection);

  @AfterMapping
  default void updateOrderEntity(@MappingTarget OrderEntity orderEntity){
    for(OrderItemEntity orderItemEntity : orderEntity.getOrderItems()){
      orderItemEntity.setOrder(orderEntity);
    }
  }
}
