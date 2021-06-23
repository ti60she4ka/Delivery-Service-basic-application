package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import storages.AbstractDataStorage;
import storages.ClientDataStorage;
import storages.ShopDataStorage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Json {
    private static final String CLIENT_DATA_STORAGE_PATH = "src/main/java/files/ClientDataStorage.json";
    private static final String SHOP_DATA_STORAGE_PATH = "src/main/java/files/ShopDataStorage.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Json() {}

    public static void serializeClientDataStorage(){
        serializeDataStorage(ClientDataStorage.getInstance(), CLIENT_DATA_STORAGE_PATH);
    }

    public static void serializeShopDataStorage(){
        serializeDataStorage(ShopDataStorage.getInstance(), SHOP_DATA_STORAGE_PATH);
    }

    public static void deserializeClientDataStorage(){
        try(FileReader fileReader = new FileReader(CLIENT_DATA_STORAGE_PATH)){

            ClientDataStorage.setInstance(gson.fromJson(fileReader, ClientDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void deserializeShopDataStorage(){
        try(FileReader fileReader = new FileReader(SHOP_DATA_STORAGE_PATH)){

            ShopDataStorage.setInstance(gson.fromJson(fileReader, ShopDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private static void serializeDataStorage(AbstractDataStorage<?> dataStorage, String path){
        String jsonDataStorage = gson.toJson(dataStorage, AbstractDataStorage.class);
        try(FileWriter fileOutputStream = new FileWriter(path)){
            fileOutputStream.write(jsonDataStorage);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
