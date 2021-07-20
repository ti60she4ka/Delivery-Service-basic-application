package by.exposit.handlers;

import by.exposit.model.enums.file.FileType;
import by.exposit.parsers.JSONParser;
import by.exposit.validators.JSONValidator;

public class JSONFileHandler extends FileHandler {

  public JSONFileHandler() {
    setParser(new JSONParser());
    setValidator(new JSONValidator());
    setFileType(FileType.JSON);
  }
}
