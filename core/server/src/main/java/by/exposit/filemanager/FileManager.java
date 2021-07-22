package by.exposit.filemanager;

import by.exposit.exceptions.FileFormatNotSupportedException;
import by.exposit.exceptions.FileIsNotValidException;
import by.exposit.handlers.FileHandler;
import by.exposit.handlers.JSONFileHandler;
import by.exposit.model.enums.file.FileType;
import by.exposit.reader.TextReader;
import by.exposit.writer.TextWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileManager {

  private FileHandler fileHandler;

  public void serialize(Object objectToSerialize, String path, Type type) {
    try {
      fileHandler = createFileHandler(path);

      String data = fileHandler.getParser().serialize(objectToSerialize, type);
      TextWriter.writeToFile(data, path);
    } catch (FileFormatNotSupportedException e) {
      log.error("File with path = '{}' is not supported", path);
    }
  }

  public Object deserialize(String path, Type type) {
    try {
      fileHandler = createFileHandler(path);
    } catch (FileFormatNotSupportedException e) {
      log.error("File with path = '{}' is not supported", path);
    }

    try {
      fileHandler.getValidator().validate(path);
      String data = TextReader.readFromFile(path);
      return fileHandler.getParser().deserialize(data, type);
    } catch (FileIsNotValidException e) {
      log.error("File with path = '{}' is not valid", path);
    } catch (IOException e) {
      log.error("File with path = '{}' not found", path);
    }

    return null;
  }

  private FileHandler createFileHandler(String path) {
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

  private String getFileExtension(String path) {
    int index = path.indexOf('.');
    return index == -1 ? "" : path.substring(index);
  }
}
