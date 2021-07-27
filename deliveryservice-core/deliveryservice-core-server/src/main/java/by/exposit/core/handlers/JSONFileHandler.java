package by.exposit.core.handlers;

import by.exposit.core.model.enums.file.FileType;
import by.exposit.core.parsers.json.JSONParser;
import by.exposit.core.validators.JSONValidator;

public class JSONFileHandler extends FileHandler {

  public JSONFileHandler() {
    setParser(new JSONParser());
    setValidator(new JSONValidator());
    setFileType(FileType.JSON);
  }
}
