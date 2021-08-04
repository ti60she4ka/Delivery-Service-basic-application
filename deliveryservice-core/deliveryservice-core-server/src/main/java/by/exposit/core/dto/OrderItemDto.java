package by.exposit.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

  private ArticleDto article;

  private Integer quantity;

  private Double price;
}
