package utilities.parsers;

import storages.AbstractDataStorage;

import java.lang.reflect.Type;

public class XMLParser implements Parser {
    @Override
    public String serializeDataStorage(AbstractDataStorage<?> dataStorage) {
        return null;
    }

    @Override
    public AbstractDataStorage<?> deserializeDataStorage(String data, Type type) {
        return null;
    }
}
