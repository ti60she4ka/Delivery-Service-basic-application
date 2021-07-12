package utilities.file;

import exceptions.FileIsNotValidException;
import exceptions.FilePathIsNotValidException;
import lombok.Setter;
import model.entities.BaseEntity;
import storages.AbstractDataStorage;
import utilities.parsers.Parser;
import utilities.reader.TextReader;
import utilities.validators.Validator;
import utilities.writer.TextWriter;

import java.io.IOException;
import java.lang.reflect.Type;

public class FileManager {
    @Setter
    private static Parser parser;
    @Setter
    private static Validator validator;

    private FileManager(){

    }

    public static void serializeDataStorage(AbstractDataStorage<?> dataStorage, String path) throws IOException {
        String data = parser.serializeDataStorage(dataStorage);
        TextWriter.writeToFile(data, path);
    }

    public static AbstractDataStorage<?> deserializeDataStorage(String path, Type type) throws IOException {
        try {
            validator.validate(path);
            String data = TextReader.readFromFile(path);
            return parser.deserializeDataStorage(data, type);
        } catch (FileIsNotValidException | FilePathIsNotValidException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
