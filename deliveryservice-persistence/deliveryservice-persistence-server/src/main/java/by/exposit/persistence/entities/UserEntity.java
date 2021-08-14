package by.exposit.persistence.entities;

import by.exposit.core.model.enums.user.Role;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BasePersistenceEntity {

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "password", nullable = false)
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Role role;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @Column(name = "address", nullable = false)
  private String address;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private Collection<OrderEntity> orders;

  @Override
  public String toString() {
    return "UserEntity (" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", address='" + address + '\'' +
        ')';
  }
}
