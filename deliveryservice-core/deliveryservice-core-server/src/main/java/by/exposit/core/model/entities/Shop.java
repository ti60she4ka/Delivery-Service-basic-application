package by.exposit.core.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Shop extends BaseEntity {

  private String name;
  private String city;
  private String address;
  private Long version;
}
