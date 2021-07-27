package by.exposit.web.requests;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeValueRequest {

  @NotNull
  private @Valid AttributeRequest attribute;

  @NotNull
  private Object value;
}
