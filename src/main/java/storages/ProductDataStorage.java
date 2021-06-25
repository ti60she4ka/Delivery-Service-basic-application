package storages;

import model.entities.Product;

public class ProductDataStorage extends AbstractDataStorage<Product> {
    private static ProductDataStorage instance;

    private ProductDataStorage(){}

    public static ProductDataStorage getInstance(){
        if(instance == null){
            instance = new ProductDataStorage();
        }

        return instance;
    }

    public static void setInstance(ProductDataStorage instance) {
        ProductDataStorage.instance = instance;
    }
}
