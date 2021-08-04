package by.exposit.web.requests;

import by.exposit.core.model.enums.status.OrderStatus;
import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

  @NotNull(message = "User ID should not be null")
  private Long userId;

  @NotNull(message = "Order items should not be null")
  private Collection<@Valid OrderItemRequest> orderItems;

  @NotNull(message = "Order status should not be null")
  private OrderStatus status;
}
