package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.Product;

public class ProductDataStorage extends AbstractDataStorage<Product> {

  public ProductDataStorage(FileManager fileManager, String path,
      Class<ProductDataStorage> type) {
    super(fileManager, path, type);
  }
}
