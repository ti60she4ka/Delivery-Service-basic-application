package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopRequest {

  @NotNull(message = "Shop name should not be null")
  @Size(min = 2, max = 30, message = "Shop name should be between 2 and 30 characters")
  private String name;

  @NotNull(message = "City should not be null")
  @Size(min = 2, max = 30, message = "City should be between 2 and 30 characters")
  private String city;

  @NotNull(message = "Address should not be null")
  @Size(min = 2, max = 30, message = "Address should be between 2 and 30 characters")
  private String address;
}
