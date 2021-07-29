package by.exposit.core.model.entities;

import by.exposit.core.model.enums.status.OrderStatus;
import java.time.LocalDate;
import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Order extends BaseEntity {

  private User user;
  private Collection<OrderItem> orderItems;
  private double totalPrice;
  private OrderStatus status;
  private LocalDate creationDate;
  private LocalDate updateDate;
  private LocalDate completionDate;
}
