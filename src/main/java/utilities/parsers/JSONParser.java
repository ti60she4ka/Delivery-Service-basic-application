package utilities.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import storages.AbstractDataStorage;

import java.lang.reflect.Type;

public class JSONParser implements Parser {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String serializeDataStorage(AbstractDataStorage<?> dataStorage) {
        return gson.toJson(dataStorage, AbstractDataStorage.class);
    }

    @Override
    public AbstractDataStorage<?> deserializeDataStorage(String data, Type type) {
        return gson.fromJson(data, type);
    }
}
