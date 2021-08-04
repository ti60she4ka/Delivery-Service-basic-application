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
  @Size(min = 2, max = 30, message = "Product name should be between 2 and 30 characters")
  private String name;

  private Collection<@NotNull(message = "Category ID should not be null") Long> categoryIdCollection;

  private Collection<@Valid AttributeRequest> attributes;
}