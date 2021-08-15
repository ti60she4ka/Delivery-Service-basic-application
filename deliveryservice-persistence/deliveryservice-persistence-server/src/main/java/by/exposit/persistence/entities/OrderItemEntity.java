package by.exposit.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
@Table(name = "order_item")
public class OrderItemEntity extends BasePersistenceEntity {

  @ManyToOne
  @JoinColumn(name = "article_id", referencedColumnName = "id", nullable = false)
  private ArticleEntity article;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  @Column(name = "price", nullable = false)
  private Double price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", referencedColumnName = "id")
  private OrderEntity order;

  @Override
  public String toString() {
    return "OrderItemEntity (" +
        "id=" + id +
        ", article=" + article +
        ", quantity=" + quantity +
        ", price=" + price +
        ')';
  }
}
