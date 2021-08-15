package by.exposit.persistence.entities;

import by.exposit.core.model.enums.status.OrderStatus;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
@Table(name = "orders")
public class OrderEntity extends BasePersistenceEntity {

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  private Collection<OrderItemEntity> orderItems;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private OrderStatus status;

  @Column(name = "total_cost", nullable = false)
  private Double totalCost;

  @Column(name = "creation_date", nullable = false)
  private LocalDate creationDate;

  @Column(name = "update_date")
  private LocalDate updateDate;

  @Column(name = "completion_date")
  private LocalDate completionDate;

  @Version
  @Column(name = "version")
  private Long version;

  @Override
  public String toString() {
    return "OrderEntity (" +
        "id=" + id +
        ", user=" + user +
        ", orderItems=" + orderItems +
        ", status=" + status +
        ", totalCost=" + totalCost +
        ", creationDate=" + creationDate +
        ", updateDate=" + updateDate +
        ", completionDate=" + completionDate +
        ')';
  }
}
