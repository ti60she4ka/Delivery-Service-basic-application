package utilities.handlers;

import lombok.Getter;
import lombok.Setter;
import model.enums.file.FileType;
import utilities.parsers.Parser;
import utilities.validators.Validator;

@Getter
@Setter
public abstract class FileHandler {
    private Parser parser;
    private Validator validator;
    private FileType fileType;
}
