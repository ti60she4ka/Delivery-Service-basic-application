package utilities.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextWriter {
    public static void writeToFile(String data, String filePath) throws IOException {
        Path path = Paths.get(filePath);

        Files.deleteIfExists(path);
        Files.createFile(path);

        Files.writeString(path, data);
    }
}
