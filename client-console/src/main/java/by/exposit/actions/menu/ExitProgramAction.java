package by.exposit.actions.menu;

import by.exposit.actions.Action;
import by.exposit.filemanager.FileManager;
import by.exposit.storages.AbstractDataStorage;
import by.exposit.storages.OrderDataStorage;
import by.exposit.storages.ProductDataStorage;
import by.exposit.storages.ShopDataStorage;
import by.exposit.storages.UserDataStorage;

public class ExitProgramAction implements Action {

  private final FileManager fileManager;
  private final UserDataStorage userDataStorage;
  private final ProductDataStorage productDataStorage;
  private final ShopDataStorage shopDataStorage;
  private final OrderDataStorage orderDataStorage;

  public ExitProgramAction(FileManager fileManager, UserDataStorage userDataStorage,
      ProductDataStorage productDataStorage, ShopDataStorage shopDataStorage,
      OrderDataStorage orderDataStorage) {
    this.fileManager = fileManager;
    this.userDataStorage = userDataStorage;
    this.productDataStorage = productDataStorage;
    this.shopDataStorage = shopDataStorage;
    this.orderDataStorage = orderDataStorage;
  }

  @Override
  public void doAction(int index) {
    save();
    System.exit(0);
  }

  private void save() {
    fileManager.serialize(
        userDataStorage,
        "core/server/src/main/java/by/exposit/files/UserDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        productDataStorage,
        "core/server/src/main/java/by/exposit/files/ProductDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        shopDataStorage,
        "core/server/src/main/java/by/exposit/files/ShopDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        orderDataStorage,
        "core/server/src/main/java/by/exposit/files/OrderDataStorage.json",
        AbstractDataStorage.class
    );
  }
}
