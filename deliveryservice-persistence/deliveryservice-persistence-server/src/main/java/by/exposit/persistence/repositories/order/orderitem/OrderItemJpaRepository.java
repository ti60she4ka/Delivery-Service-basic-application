package by.exposit.persistence.repositories.order.orderitem;

import by.exposit.persistence.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItemEntity, Long> {

  void deleteAllByOrderId(Long id);
}
