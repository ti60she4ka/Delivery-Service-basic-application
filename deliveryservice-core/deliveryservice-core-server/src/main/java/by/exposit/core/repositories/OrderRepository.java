package by.exposit.core.repositories;

import by.exposit.core.model.entities.Order;

public interface OrderRepository extends AbstractRepository<Order> {

  boolean existsById(Long id);
}
