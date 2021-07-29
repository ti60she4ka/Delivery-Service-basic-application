package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeRequest {

  @NotNull(message = "Attribute name should should not be null")
  @Size(min = 2, max = 30, message = "Attribute name should be between 2 and 30 characters")
  private String name;

  @NotNull(message = "Attribute description should not be null")
  @Size(min = 2, max = 300, message = "Attribute description should be between 2 and 300 characters")
  private String description;

  @NotNull(message = "Attribute type should not be null")
  private Class<?> type;
}
