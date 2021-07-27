package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeRequest {

  @NotNull(message = "Attribute name should should not be null")
  @Size(min = 2, message = "Attribute name should have at least 2 characters")
  private String name;

  @NotNull(message = "Attribute type should not be null")
  @Size(min = 2, message = "Attribute name should have at least 2 characters")
  private String description;

  @NotNull(message = "Attribute type should not be null")
  private Class<?> type;
}
