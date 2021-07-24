package by.exposit.core.repositories.shop;

import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.AbstractRepositoryImpl;
import by.exposit.core.storages.ShopDataStorage;

public class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop> implements ShopRepository {

  private final ShopDataStorage shopDataStorage;

  public ShopRepositoryImpl(ShopDataStorage shopDataStorage) {
    super(shopDataStorage);
    this.shopDataStorage = shopDataStorage;
    entityType = "Shop";
  }
}
