package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.OrderItem;
import by.exposit.persistence.entities.OrderItemEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemPersistenceMapper {

  OrderItemEntity toPersistenceEntity(OrderItem orderItem);

  OrderItem toEntity(OrderItemEntity orderItemEntity);

  Collection<OrderItemEntity> toPersistenceEntityCollection(Collection<OrderItem> orderItems);

  Collection<OrderItem> toEntityCollection(Collection<OrderItemEntity> orderItemEntityCollection);
}
