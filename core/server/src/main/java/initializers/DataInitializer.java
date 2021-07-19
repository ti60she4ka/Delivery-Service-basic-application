package initializers;

import filemanager.FileManager;
import java.io.IOException;
import storages.OrderDataStorage;
import storages.ProductDataStorage;
import storages.ShopDataStorage;
import storages.UserDataStorage;

public class DataInitializer implements Initializer {

  private static final String USER_DATA_STORAGE_PATH = "core/server/src/main/java/files/UserDataStorage.json";
  private static final String SHOP_DATA_STORAGE_PATH = "core/server/src/main/java/files/ShopDataStorage.json";
  private static final String PRODUCT_DATA_STORAGE_PATH = "core/server/src/main/java/files/ProductDataStorage.json";
  private static final String ORDER_DATA_STORAGE_PATH = "core/server/src/main/java/files/OrderDataStorage.json";

  @Override
  public void init() {
    try {
      UserDataStorage.setInstance((UserDataStorage)
          FileManager.deserialize(USER_DATA_STORAGE_PATH, UserDataStorage.class));

      ShopDataStorage.setInstance((ShopDataStorage)
          FileManager.deserialize(SHOP_DATA_STORAGE_PATH, ShopDataStorage.class));

      ProductDataStorage.setInstance((ProductDataStorage)
          FileManager.deserialize(PRODUCT_DATA_STORAGE_PATH, ProductDataStorage.class));

      OrderDataStorage.setInstance((OrderDataStorage)
          FileManager.deserialize(ORDER_DATA_STORAGE_PATH, OrderDataStorage.class));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
