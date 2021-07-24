package by.exposit.client.actions.menu;

import by.exposit.client.actions.Action;
import by.exposit.core.filemanager.FileManager;
import by.exposit.core.storages.AbstractDataStorage;
import by.exposit.core.storages.OrderDataStorage;
import by.exposit.core.storages.ProductDataStorage;
import by.exposit.core.storages.ShopDataStorage;
import by.exposit.core.storages.UserDataStorage;

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
        "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/UserDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        productDataStorage,
        "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/ProductDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        shopDataStorage,
        "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/ShopDataStorage.json",
        AbstractDataStorage.class
    );

    fileManager.serialize(
        orderDataStorage,
        "deliveryservice-core/deliveryservice-core-server/src/main/java/by/exposit/core/files/OrderDataStorage.json",
        AbstractDataStorage.class
    );
  }
}
