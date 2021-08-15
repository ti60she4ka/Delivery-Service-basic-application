package by.exposit.persistence.entities;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "shop")
public class ShopEntity extends BasePersistenceEntity {

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "address", nullable = false)
  private String address;

  @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Collection<ArticleEntity> articles;

  @Version
  @Column(name = "version")
  private Long version;

  @Override
  public String toString() {
    return "ShopEntity (" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", city='" + city + '\'' +
        ", address='" + address + '\'' +
        ')';
  }
}
