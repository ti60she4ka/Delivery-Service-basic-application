package by.exposit.core.model.entities;

import by.exposit.core.model.enums.user.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

  private String username;
  private String password;
  private Role role;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String address;
}
