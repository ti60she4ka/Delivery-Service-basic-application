package by.exposit.web.requests;

import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

  @NotNull(message = "Product name should not be null")
  @Size(min = 2, message = "Product name should have at least 2 characters")
  private String name;

  private Collection<Long> categoryIdCollection;

  private Collection<AttributeValueRequest> attributeValues;
}