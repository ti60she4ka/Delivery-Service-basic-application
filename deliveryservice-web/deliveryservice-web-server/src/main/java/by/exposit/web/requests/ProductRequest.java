package by.exposit.web.requests;

import java.util.Collection;
import javax.validation.Valid;
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

  private Collection<@NotNull(message = "Category ID should not be null") Long> categoryIdCollection;

  private Collection<@Valid AttributeValueRequest> attributeValues;
}