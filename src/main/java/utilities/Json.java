package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import storages.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {
    private static final String CLIENT_DATA_STORAGE_PATH = "src/main/java/files/ClientDataStorage.json";
    private static final String SHOP_DATA_STORAGE_PATH = "src/main/java/files/ShopDataStorage.json";
    private static final String PRODUCT_DATA_STORAGE_PATH = "src/main/java/files/ProductDataStorage.json";
    private static final String ORDER_DATA_STORAGE_PATH = "src/main/java/files/OrderDataStorage.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Json() {
    }

    public static void serializeClientDataStorage() {
        serializeDataStorage(ClientDataStorage.getInstance(), CLIENT_DATA_STORAGE_PATH);
    }

    public static void serializeShopDataStorage() {
        serializeDataStorage(ShopDataStorage.getInstance(), SHOP_DATA_STORAGE_PATH);
    }

    public static void serializeProductDataStorage() {
        serializeDataStorage(ProductDataStorage.getInstance(), PRODUCT_DATA_STORAGE_PATH);
    }

    public static void serializeOrderDataStorage() {
        serializeDataStorage(OrderDataStorage.getInstance(), ORDER_DATA_STORAGE_PATH);
    }

    public static void deserializeClientDataStorage() {
        try (FileReader fileReader = new FileReader(CLIENT_DATA_STORAGE_PATH)) {

            ClientDataStorage.setInstance(gson.fromJson(fileReader, ClientDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void deserializeShopDataStorage() {
        try (FileReader fileReader = new FileReader(SHOP_DATA_STORAGE_PATH)) {

            ShopDataStorage.setInstance(gson.fromJson(fileReader, ShopDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void deserializeProductDataStorage() {
        try (FileReader fileReader = new FileReader(PRODUCT_DATA_STORAGE_PATH)) {

            ProductDataStorage.setInstance(gson.fromJson(fileReader, ProductDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void deserializeOrderDataStorage() {
        try (FileReader fileReader = new FileReader(ORDER_DATA_STORAGE_PATH)) {

            OrderDataStorage.setInstance(gson.fromJson(fileReader, OrderDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void serializeDataStorage(AbstractDataStorage<?> dataStorage, String path) {
        String jsonDataStorage = gson.toJson(dataStorage, AbstractDataStorage.class);
        try (FileWriter fileOutputStream = new FileWriter(path)) {
            fileOutputStream.write(jsonDataStorage);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
