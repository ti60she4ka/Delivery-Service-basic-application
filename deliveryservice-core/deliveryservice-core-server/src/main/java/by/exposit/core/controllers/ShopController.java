package by.exposit.core.controllers;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.services.shop.ShopService;
import java.util.Collection;

public class ShopController {

  private final ShopService shopService;

  public ShopController(ShopService shopService) {
    this.shopService = shopService;
  }

  public void create(Shop shop) throws EntityCannotBeAddedException {
    shopService.create(shop);
  }

  public Collection<Shop> getAll() {
    return shopService.getAll();
  }

  public void deleteById(Long id) throws EntityNotFoundException {
    shopService.deleteById(id);
  }

  public Shop getById(Long id) throws EntityNotFoundException {
    return shopService.getById(id);
  }
}
