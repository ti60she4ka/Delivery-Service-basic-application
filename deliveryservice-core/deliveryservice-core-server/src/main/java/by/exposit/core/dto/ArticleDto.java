package by.exposit.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto {

  private Long id;

  private ProductDto product;

  private ShopDto shop;

  private Double price;

  private Integer quantity;
}
