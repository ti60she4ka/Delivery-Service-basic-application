package by.exposit.repositories.order;

import by.exposit.model.entities.Order;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.OrderDataStorage;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {

  private final OrderDataStorage orderDataStorage;

  public OrderRepositoryImpl(OrderDataStorage orderDataStorage) {
    super(orderDataStorage);
    this.orderDataStorage = orderDataStorage;
    entityType = "Order";
  }
}
