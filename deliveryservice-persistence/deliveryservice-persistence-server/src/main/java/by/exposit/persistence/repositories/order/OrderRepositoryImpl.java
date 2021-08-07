package by.exposit.persistence.repositories.order;

import by.exposit.core.model.entities.Order;
import by.exposit.core.repositories.OrderRepository;
import by.exposit.persistence.entities.OrderEntity;
import by.exposit.persistence.entities.OrderItemEntity;
import by.exposit.persistence.mappers.OrderPersistenceMapper;
import by.exposit.persistence.repositories.order.orderitem.OrderItemJpaRepository;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional
  public Order create(Order order) {
    return orderMapper.toEntity(orderRepository.save(orderMapper.toPersistenceEntity(order)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Order> getAll() {
    return orderMapper.toEntityCollection(orderRepository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Order order) {
    orderItemRepository.deleteAllByOrderId(order.getId());

    orderRepository.save(orderMapper.toPersistenceEntity(order));
  }

  @Override
  @Transactional(readOnly = true)
  public Order getById(Long id) {
    return orderMapper.toEntity(orderRepository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return orderRepository.existsById(id);
  }
}
