package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.Shop;

public class ShopDataStorage extends AbstractDataStorage<Shop> {

  public ShopDataStorage(FileManager fileManager, String path,
      Class<ShopDataStorage> type) {
    super(fileManager, path, type);
  }
}
