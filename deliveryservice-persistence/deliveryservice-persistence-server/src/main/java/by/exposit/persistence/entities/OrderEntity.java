package by.exposit.persistence.entities;

import by.exposit.core.model.enums.status.OrderStatus;
import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity extends BasePersistenceEntity {

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "order")
  private Collection<OrderItemEntity> orderItems;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private OrderStatus status;

  @Column(name = "creation_date", nullable = false)
  private LocalDate creationDate;

  @Column(name = "update_date")
  private LocalDate updateDate;

  @Column(name = "competion_date")
  private LocalDate completionDate;
}
