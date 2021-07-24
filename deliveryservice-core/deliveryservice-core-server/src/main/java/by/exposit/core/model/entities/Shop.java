package by.exposit.core.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Shop extends BaseEntity {

  private String name;
  private String city;
  private String address;

  public Shop(Shop shop) {
    this.name = shop.getName();
    this.city = shop.getCity();
    this.address = shop.getAddress();
  }

  @Override
  public String toString() {
    return "ID — " + id +
        "\nName — " + name +
        "\nCity — " + city +
        "\nAddress — " + address;
  }
}
