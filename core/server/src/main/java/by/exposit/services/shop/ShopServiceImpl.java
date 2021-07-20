package by.exposit.services.shop;

import by.exposit.model.entities.Shop;
import by.exposit.repositories.shop.ShopRepository;
import by.exposit.services.AbstractServiceImpl;

public class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {

  private final ShopRepository shopRepository;

  public ShopServiceImpl(ShopRepository shopRepository) {
    super(shopRepository);
    this.shopRepository = shopRepository;
  }
}
