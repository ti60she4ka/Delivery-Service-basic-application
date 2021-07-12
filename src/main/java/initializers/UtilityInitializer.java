package initializers;

import utilities.file.FileManager;
import utilities.parsers.JSONParser;

public class UtilityInitializer implements Initializer {
    @Override
    public void init() {
        FileManager.setParser(new JSONParser());
    }
}
