package by.exposit.core.services.order;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Order;
import by.exposit.core.repositories.order.OrderRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDto> implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository, BaseMapper<Order, OrderDto> mapper) {
    super(orderRepository, mapper);
    this.orderRepository = orderRepository;
  }
}
