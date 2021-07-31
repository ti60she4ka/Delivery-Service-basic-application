package by.exposit.persistence.entities;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity extends BasePersistenceEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private CategoryEntity parentCategory;

  @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
  private Collection<ProductEntity> products;
}
