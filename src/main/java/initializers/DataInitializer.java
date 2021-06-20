package initializers;

import utilities.Json;

public class DataInitializer implements Initializer{
    @Override
    public void init() {
        Json.deserializeClientDataStorage();
    }
}
