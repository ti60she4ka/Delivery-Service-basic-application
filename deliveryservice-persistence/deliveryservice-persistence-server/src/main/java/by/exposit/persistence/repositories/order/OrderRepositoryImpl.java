package by.exposit.persistence.repositories.order;

import by.exposit.core.exceptions.EntityAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Order;
import by.exposit.core.repositories.OrderRepository;
import by.exposit.persistence.entities.OrderEntity;
import by.exposit.persistence.entities.OrderItemEntity;
import by.exposit.persistence.mappers.OrderPersistenceMapper;
import by.exposit.persistence.repositories.order.orderitem.OrderItemJpaRepository;
import java.util.Collection;

public class OrderRepositoryImpl implements OrderRepository {

  private final OrderJpaRepository orderRepository;
  private final OrderItemJpaRepository orderItemRepository;
  private final OrderPersistenceMapper orderMapper;

  public OrderRepositoryImpl(OrderJpaRepository orderRepository,
      OrderItemJpaRepository orderItemRepository, OrderPersistenceMapper orderMapper) {
    this.orderRepository = orderRepository;
    this.orderItemRepository = orderItemRepository;
    this.orderMapper = orderMapper;
  }

  @Override
  public Order create(Order order) {
    OrderEntity orderEntity = orderMapper.toPersistenceEntity(order);

    for(OrderItemEntity orderItemEntity : orderEntity.getOrderItems()){
      orderItemEntity.setOrder(orderEntity);
    }

    return orderMapper.toEntity(orderRepository.save(orderEntity));
  }

  @Override
  public Collection<Order> getAll() {
    return orderMapper.toEntityCollection(orderRepository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  public void update(Order order) {
    orderItemRepository.deleteAllByOrOrderId(order.getId());
    OrderEntity orderEntity = orderMapper.toPersistenceEntity(order);

    for(OrderItemEntity orderItemEntity : orderEntity.getOrderItems()){
      orderItemEntity.setOrder(orderEntity);
    }

    orderRepository.save(orderMapper.toPersistenceEntity(order));
  }

  @Override
  public Order getById(Long id) {
    return orderMapper.toEntity(orderRepository.getById(id));
  }

  @Override
  public boolean existsById(Long id) {
    return orderRepository.existsById(id);
  }
}
