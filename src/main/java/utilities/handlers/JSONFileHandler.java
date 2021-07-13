package utilities.handlers;

import model.enums.file.FileType;
import utilities.parsers.JSONParser;
import utilities.validators.JSONValidator;

public class JSONFileHandler extends FileHandler {
    public JSONFileHandler(){
        setParser(new JSONParser());
        setValidator(new JSONValidator());
        setFileType(FileType.JSON);
    }
}
