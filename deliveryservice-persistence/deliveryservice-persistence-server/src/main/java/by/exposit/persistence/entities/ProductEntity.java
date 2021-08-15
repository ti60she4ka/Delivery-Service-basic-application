package by.exposit.persistence.entities;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "product")
public class ProductEntity extends BasePersistenceEntity {

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @ManyToMany
  @JoinTable(
      name = "product_category",
      joinColumns = {@JoinColumn(name = "product_id")},
      inverseJoinColumns = {@JoinColumn(name = "category_id")}
  )
  private Collection<CategoryEntity> categories;

  @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  private Collection<AttributeEntity> attributes;

  @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
  private Collection<ArticleEntity> articles;

  @Version
  @Column(name = "version")
  private Long version;

  @Override
  public String toString() {
    return "ProductEntity (" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", categories=" + categories +
        ", attributes=" + attributes +
        ')';
  }
}
