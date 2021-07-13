package utilities.parsers;

import storages.AbstractDataStorage;

import java.lang.reflect.Type;

public interface Parser {
    String serialize(Object objectToSerialize, Type type);

    Object deserialize(String data, Type type);
}
