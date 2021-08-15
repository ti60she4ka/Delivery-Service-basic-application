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
@Table(name = "attribute")
public class AttributeEntity extends BasePersistenceEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "type", nullable = false)
  private Class<?> type;

  @Column(name = "value",nullable = false)
  private String value;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id", referencedColumnName = "id")
  private ProductEntity product;

  @Override
  public String toString() {
    return "AttributeEntity (" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", type=" + type +
        ", value='" + value + '\'' +
        ')';
  }
}
