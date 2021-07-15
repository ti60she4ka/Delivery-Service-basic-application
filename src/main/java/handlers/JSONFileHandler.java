package handlers;

import model.enums.file.FileType;
import parsers.JSONParser;
import validators.JSONValidator;

public class JSONFileHandler extends FileHandler {
    public JSONFileHandler(){
        setParser(new JSONParser());
        setValidator(new JSONValidator());
        setFileType(FileType.JSON);
    }
}
