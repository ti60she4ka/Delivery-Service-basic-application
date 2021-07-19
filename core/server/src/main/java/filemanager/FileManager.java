package filemanager;

import exceptions.FileFormatNotSupportedException;
import exceptions.FileIsNotValidException;
import handlers.FileHandler;
import handlers.JSONFileHandler;
import java.io.IOException;
import java.lang.reflect.Type;
import model.enums.file.FileType;
import reader.TextReader;
import writer.TextWriter;

public class FileManager {

  private static FileHandler fileHandler;

  private FileManager() {

  }

  public static void serialize(Object objectToSerialize, String path, Type type)
      throws IOException {
    try {
      fileHandler = createFileHandler(path);

      String data = fileHandler.getParser().serialize(objectToSerialize, type);
      TextWriter.writeToFile(data, path);
    } catch (FileFormatNotSupportedException e) {
      System.out.println(e.getMessage());
    }
  }

  public static Object deserialize(String path, Type type) throws IOException {
    try {
      fileHandler = createFileHandler(path);

      fileHandler.getValidator().validate(path);
      String data = TextReader.readFromFile(path);
      return fileHandler.getParser().deserialize(data, type);
    } catch (FileIsNotValidException | FileFormatNotSupportedException e) {
      System.out.println(e.getMessage());
    }

    return null;
  }

  private static FileHandler createFileHandler(String path) {
    switch (getFileExtension(path)) {
      case ".json":
        if (fileHandler == null || fileHandler.getFileType() != FileType.JSON) {
          return new JSONFileHandler();
        }
        return fileHandler;
      default:
        throw new FileFormatNotSupportedException(path);
    }
  }

  private static String getFileExtension(String path) {
    int index = path.indexOf('.');
    return index == -1 ? "" : path.substring(index);
  }
}
