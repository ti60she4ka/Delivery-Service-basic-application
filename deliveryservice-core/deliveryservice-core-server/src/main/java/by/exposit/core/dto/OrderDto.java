package by.exposit.core.dto;

import by.exposit.core.model.enums.status.OrderStatus;
import java.time.LocalDate;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

  private Long id;

  private UserDto user;

  private Collection<OrderItemDto> orderItems;

  private OrderStatus status;

  private Double totalCost;

  private LocalDate creationDate;

  private LocalDate updateDate;

  private LocalDate completionDate;
}
