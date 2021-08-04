package by.exposit.web.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

  @NotNull(message = "Username should not be null")
  @Size(min = 2, max = 30, message = "Username should be between 2 and 30 characters")
  private String username;

  @NotNull(message = "First name should not be null")
  @Size(min = 2, max = 30, message = "First name should be between 2 and 30 characters")
  private String firstName;

  @NotNull(message = "Last name should not be null")
  @Size(min = 2, max = 30, message = "Last name should be between 2 and 30 characters")
  private String lastName;

  @Email(message = "Email should be a well-formed email address")
  private String email;

  @NotNull(message = "Phone number should not be null")
  private String phoneNumber;

  @NotNull(message = "Address should not be null")
  @Size(min = 5, max = 100, message = "Address should be between 5 and 100 characters")
  private String address;
}
