package initializers;

import storages.OrderDataStorage;
import storages.ProductDataStorage;
import storages.ShopDataStorage;
import storages.UserDataStorage;
import utilities.Json;
import utilities.file.FileManager;

import java.io.IOException;

public class DataInitializer implements Initializer {
    private static final String USER_DATA_STORAGE_PATH = "src/main/java/files/UserDataStorage.json";
    private static final String SHOP_DATA_STORAGE_PATH = "src/main/java/files/ShopDataStorage.json";
    private static final String PRODUCT_DATA_STORAGE_PATH = "src/main/java/files/ProductDataStorage.json";
    private static final String ORDER_DATA_STORAGE_PATH = "src/main/java/files/OrderDataStorage.json";

    @Override
    public void init() {
        try {
            UserDataStorage.setInstance((UserDataStorage)
                    FileManager.deserializeDataStorage(USER_DATA_STORAGE_PATH, UserDataStorage.class));

            ShopDataStorage.setInstance((ShopDataStorage)
                    FileManager.deserializeDataStorage(SHOP_DATA_STORAGE_PATH, ShopDataStorage.class));

            ProductDataStorage.setInstance((ProductDataStorage)
                    FileManager.deserializeDataStorage(PRODUCT_DATA_STORAGE_PATH, ProductDataStorage.class));

            OrderDataStorage.setInstance((OrderDataStorage)
                    FileManager.deserializeDataStorage(ORDER_DATA_STORAGE_PATH, OrderDataStorage.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
