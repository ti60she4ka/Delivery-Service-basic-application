package handlers;

import lombok.Getter;
import lombok.Setter;
import model.enums.file.FileType;
import parsers.Parser;
import validators.Validator;

@Getter
@Setter
public abstract class FileHandler {

  private Parser parser;
  private Validator validator;
  private FileType fileType;
}
