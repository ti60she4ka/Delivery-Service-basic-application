package by.exposit.web.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeValueRequest {

  @NotNull(message = "Attribute should not be null")
  private @Valid AttributeRequest attribute;

  @NotNull(message = "Value should not be null")
  private Object value;
}
