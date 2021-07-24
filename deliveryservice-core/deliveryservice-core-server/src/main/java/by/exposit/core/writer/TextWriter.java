package by.exposit.core.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextWriter {

  private TextWriter() {
  }

  public static void writeToFile(String data, String filePath) {
    Path path = Paths.get(filePath);

    try {
      Files.deleteIfExists(path);

      Files.createFile(path);

      Files.writeString(path, data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
