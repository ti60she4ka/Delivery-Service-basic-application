package repositories;

import api.repositories.ProductRepository;
import model.entities.Product;
import storages.ClientDataStorage;
import storages.ProductDataStorage;

public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {
    private static ProductRepositoryImpl instance;
    private final ProductDataStorage productDataStorage;

    private ProductRepositoryImpl(){
        super(ProductDataStorage.getInstance());
        productDataStorage = (ProductDataStorage) abstractDataStorage;
        entityType = "Product";
    }

    public static ProductRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ProductRepositoryImpl();
        }

        return instance;
    }
}
