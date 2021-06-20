package utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import storages.AbstractDataStorage;
import storages.ClientDataStorage;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Json {
    private static final String CLIENT_DATA_STORAGE_PATH = "src/main/java/files/ClientDataStorage.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Json() {}

    public static void serializeClientDataStorage(){
        String jsonDataStorage = gson.toJson(ClientDataStorage.getInstance(), AbstractDataStorage.class);
        try(FileWriter fileOutputStream = new FileWriter(CLIENT_DATA_STORAGE_PATH)){
            fileOutputStream.write(jsonDataStorage);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static void deserializeClientDataStorage(){
        try(FileReader fileReader = new FileReader(CLIENT_DATA_STORAGE_PATH)){

            ClientDataStorage.setInstance(gson.fromJson(fileReader, ClientDataStorage.class));

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
