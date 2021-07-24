package by.exposit.core.controllers;

import by.exposit.core.model.entities.Order;
import by.exposit.core.services.order.OrderService;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import java.util.Collection;

public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  public void create(Order order) throws EntityCannotBeAddedException {
    orderService.create(order);
  }

  public Collection<Order> getAll() {
    return orderService.getAll();
  }

  public void deleteById(Long id) throws EntityNotFoundException {
    orderService.deleteById(id);
  }

  public Order getById(Long id) throws EntityNotFoundException {
    return orderService.getById(id);
  }
}
