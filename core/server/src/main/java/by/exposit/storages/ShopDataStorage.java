package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.Shop;

public class ShopDataStorage extends AbstractDataStorage<Shop> {

  public ShopDataStorage(FileManager fileManager, String path,
      Class<ShopDataStorage> type) {
    super(fileManager, path, type);
  }
}
