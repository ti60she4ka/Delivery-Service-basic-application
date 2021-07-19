package reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextReader {

  private TextReader() {
  }

  public static String readFromFile(String filePath) throws IOException {
    Path path = Paths.get(filePath);

    if (Files.notExists(path)) {
      throw new FileNotFoundException("File with path = " + filePath + " not found!");
    }

    return Files.readString(path);
  }
}
