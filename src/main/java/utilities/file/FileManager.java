package utilities.file;

import lombok.Setter;
import storages.AbstractDataStorage;
import utilities.parsers.Parser;
import utilities.reader.TextReader;
import utilities.writer.TextWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class FileManager {
    private static FileManager instance;
    @Setter
    private static Parser parser;

    private FileManager(){

    }

    public static void serializeDataStorage(AbstractDataStorage<?> dataStorage, String path) throws IOException {
        String data = parser.serializeDataStorage(dataStorage);
        TextWriter.writeToFile(data, path);
    }

    public static AbstractDataStorage<?> deserializeDataStorage(String path, Type type) throws IOException {
        String data = TextReader.readFromFile(path);
        //validation

        return parser.deserializeDataStorage(data, type);
    }
}
