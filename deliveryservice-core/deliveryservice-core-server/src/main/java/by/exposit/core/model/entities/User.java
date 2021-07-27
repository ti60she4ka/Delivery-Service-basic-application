package by.exposit.core.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String address;
}
