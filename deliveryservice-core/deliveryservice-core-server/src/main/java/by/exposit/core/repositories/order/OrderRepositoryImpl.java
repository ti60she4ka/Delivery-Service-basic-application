package by.exposit.core.repositories.order;

import by.exposit.core.model.entities.Order;
import by.exposit.core.repositories.AbstractRepositoryImpl;
import by.exposit.core.storages.OrderDataStorage;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {

  private final OrderDataStorage orderDataStorage;

  public OrderRepositoryImpl(OrderDataStorage orderDataStorage) {
    super(orderDataStorage);
    this.orderDataStorage = orderDataStorage;
    entityType = "Order";
  }
}
