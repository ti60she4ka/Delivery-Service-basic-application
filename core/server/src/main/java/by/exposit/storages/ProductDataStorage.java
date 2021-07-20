package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.Product;

public class ProductDataStorage extends AbstractDataStorage<Product> {

  public ProductDataStorage(FileManager fileManager, String path,
      Class<ProductDataStorage> type) {
    super(fileManager, path, type);
  }
}
