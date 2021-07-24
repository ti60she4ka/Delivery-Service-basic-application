package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.Order;

public class OrderDataStorage extends AbstractDataStorage<Order> {

  public OrderDataStorage(FileManager fileManager, String path,
      Class<OrderDataStorage> type) {
    super(fileManager, path, type);
  }
}
