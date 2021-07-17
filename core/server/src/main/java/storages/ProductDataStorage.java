package storages;

import lombok.Setter;
import model.entities.Product;

public class ProductDataStorage extends AbstractDataStorage<Product> {
    @Setter
    private static ProductDataStorage instance;

    private ProductDataStorage(){}

    public static ProductDataStorage getInstance(){
        if(instance == null){
            instance = new ProductDataStorage();
        }

        return instance;
    }
}
