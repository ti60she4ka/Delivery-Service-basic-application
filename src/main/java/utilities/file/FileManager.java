package utilities.file;

import exceptions.FileIsNotValidException;
import exceptions.IllegalFileFormatException;
import lombok.Setter;
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

    public static void serialize(Object objectToSerialize, String path, Type type) throws IOException {
        String data = parser.serialize(objectToSerialize, type);
        TextWriter.writeToFile(data, path);
    }

    public static Object deserialize(String path, Type type) throws IOException {
        try {
            validator.validate(path);
            String data = TextReader.readFromFile(path);
            return parser.deserialize(data, type);
        } catch (FileIsNotValidException | IllegalFileFormatException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
