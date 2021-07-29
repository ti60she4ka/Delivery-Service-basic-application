package by.exposit.web.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

  @NotNull(message = "Category name should not be null")
  @Size(min = 2, message = "Category name should have at least 2 characters")
  private String name;

  private Long parentId;
}
