package by.exposit.handlers;

import by.exposit.model.enums.file.FileType;
import by.exposit.parsers.Parser;
import by.exposit.validators.Validator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FileHandler {

  private Parser parser;
  private Validator validator;
  private FileType fileType;
}
