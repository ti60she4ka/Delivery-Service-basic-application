package by.exposit.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {


  private Long id;

  private String username;

  private String firstName;

  private String lastName;

  private String email;

  private String phoneNumber;

  private String address;
}
