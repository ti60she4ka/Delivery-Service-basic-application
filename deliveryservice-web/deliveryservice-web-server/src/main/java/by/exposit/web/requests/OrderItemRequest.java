package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {

  @NotNull(message = "Article ID should not be null")
  private Long articleId;

  @NotNull(message = "Quantity should not be null")
  @Positive(message = "Quantity should be a positive number")
  private Integer quantity;
}
