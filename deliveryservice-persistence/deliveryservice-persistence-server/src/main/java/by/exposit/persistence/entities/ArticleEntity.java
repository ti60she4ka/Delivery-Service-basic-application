package by.exposit.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "article")
public class ArticleEntity extends BasePersistenceEntity {

  @ManyToOne
  @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
  private ShopEntity shop;

  @Column(name = "price", nullable = false)
  private Double price;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Override
  public String toString() {
    return "ArticleEntity (" +
        "id=" + id +
        ", price=" + price +
        ", quantity=" + quantity +
        ", product=" + product +
        ", shop=" + shop +
        ')';
  }
}
