package initializers;

import utilities.Json;

public class DataInitializer implements Initializer{
    @Override
    public void init() {
        Json.deserializeClientDataStorage();
        Json.deserializeShopDataStorage();
        Json.deserializeProductDataStorage();
        Json.deserializeOrderDataStorage();
    }
}
