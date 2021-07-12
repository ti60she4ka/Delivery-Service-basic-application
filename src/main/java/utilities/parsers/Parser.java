package utilities.parsers;

import storages.AbstractDataStorage;

import java.lang.reflect.Type;

public interface Parser {
    String serializeDataStorage(AbstractDataStorage<?> dataStorage);

    AbstractDataStorage<?> deserializeDataStorage(String data, Type type);
}
