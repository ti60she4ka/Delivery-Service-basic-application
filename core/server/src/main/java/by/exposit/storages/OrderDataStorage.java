package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.Order;

public class OrderDataStorage extends AbstractDataStorage<Order> {

  public OrderDataStorage(FileManager fileManager, String path,
      Class<OrderDataStorage> type) {
    super(fileManager, path, type);
  }
}
