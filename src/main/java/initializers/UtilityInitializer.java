package initializers;

import utilities.file.FileManager;
import utilities.parsers.JSONParser;
import utilities.validators.JSONValidator;

public class UtilityInitializer implements Initializer {
    @Override
    public void init() {
        FileManager.setParser(new JSONParser());
        FileManager.setValidator(new JSONValidator());
    }
}
