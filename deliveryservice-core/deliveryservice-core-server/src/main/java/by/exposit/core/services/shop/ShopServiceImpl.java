package by.exposit.core.services.shop;

import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.shop.ShopRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {

  private final ShopRepository shopRepository;

  public ShopServiceImpl(ShopRepository shopRepository) {
    super(shopRepository);
    this.shopRepository = shopRepository;
  }
}
