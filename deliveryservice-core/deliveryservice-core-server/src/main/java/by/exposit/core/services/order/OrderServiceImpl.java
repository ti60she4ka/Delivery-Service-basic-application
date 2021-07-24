package by.exposit.core.services.order;

import by.exposit.core.model.entities.Order;
import by.exposit.core.repositories.order.OrderRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    super(orderRepository);
    this.orderRepository = orderRepository;
  }
}
