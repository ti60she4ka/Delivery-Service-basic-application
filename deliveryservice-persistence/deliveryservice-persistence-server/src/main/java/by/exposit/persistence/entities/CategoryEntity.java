package by.exposit.persistence.entities;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Getter
@Setter
@Entity
@Audited
@Table(name = "category")
public class CategoryEntity extends BasePersistenceEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private CategoryEntity parentCategory;

  @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
  private Collection<ProductEntity> products;

  @Version
  @Column(name = "version")
  private Long version;

  @Override
  public String toString() {
    return "CategoryEntity (" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", parentCategory=" + parentCategory +
        ')';
  }
}
