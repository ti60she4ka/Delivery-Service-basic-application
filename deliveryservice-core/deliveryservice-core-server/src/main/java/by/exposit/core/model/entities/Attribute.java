package by.exposit.core.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Attribute {

  private String name;
  private String description;
  private Class<?> type;
}
