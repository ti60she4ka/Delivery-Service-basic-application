package by.exposit.services.order;

import by.exposit.model.entities.Order;
import by.exposit.repositories.order.OrderRepository;
import by.exposit.services.AbstractServiceImpl;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {

  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    super(orderRepository);
    this.orderRepository = orderRepository;
  }
}
