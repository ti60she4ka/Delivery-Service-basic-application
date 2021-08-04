package by.exposit.core.dto;

import by.exposit.core.model.entities.Article;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

  private ArticleDto article;

  private Integer quantity;

  private Double price;
}
