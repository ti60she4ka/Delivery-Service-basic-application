package by.exposit.repositories.shop;

import by.exposit.model.entities.Shop;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.ShopDataStorage;

public class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop> implements ShopRepository {

  private final ShopDataStorage shopDataStorage;

  public ShopRepositoryImpl(ShopDataStorage shopDataStorage) {
    super(shopDataStorage);
    this.shopDataStorage = shopDataStorage;
    entityType = "Shop";
  }
}
