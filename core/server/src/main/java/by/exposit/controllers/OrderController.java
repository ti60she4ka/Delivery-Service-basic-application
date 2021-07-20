package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Order;
import by.exposit.services.order.OrderService;
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

  public void deleteById(long id) throws EntityNotFoundException {
    orderService.deleteById(id);
  }

  public Order getById(long id) throws EntityNotFoundException {
    return orderService.getById(id);
  }
}
