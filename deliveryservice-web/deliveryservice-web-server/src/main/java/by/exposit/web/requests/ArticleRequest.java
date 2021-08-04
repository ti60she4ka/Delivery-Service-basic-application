package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleRequest {

  @NotNull(message = "Product ID should not be null")
  private Long productId;

  @NotNull(message = "Shop ID should not be null")
  private Long shopId;

  @NotNull(message = "Price should not be null")
  @Positive(message = "Price should he a positive number")
  private Double price;

  @NotNull(message = "Quantity should not be null")
  @Positive(message = "Quantity should be a positive number")
  private Integer quantity;
}
