package by.exposit.core.handlers;

import by.exposit.core.model.enums.file.FileType;
import by.exposit.core.parsers.Parser;
import by.exposit.core.validators.Validator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class FileHandler {

  private Parser parser;
  private Validator validator;
  private FileType fileType;
}
