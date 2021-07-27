package by.exposit.core.dto;

import by.exposit.core.model.entities.AttributeValue;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

  private Long id;

  private String name;

  private Collection<CategoryDto> categories;

  private Collection<AttributeValue> attributeValues;
}
