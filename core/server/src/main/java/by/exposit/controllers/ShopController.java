package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Shop;
import by.exposit.services.shop.ShopService;
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

  public void deleteById(long id) throws EntityNotFoundException {
    shopService.deleteById(id);
  }

  public Shop getById(long id) throws EntityNotFoundException {
    return shopService.getById(id);
  }
}
