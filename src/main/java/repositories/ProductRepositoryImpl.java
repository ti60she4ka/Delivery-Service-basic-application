package repositories;

import api.repositories.ProductRepository;
import exceptions.EntityCannotBeAddedException;
import exceptions.ProductCannotBeAddedException;
import model.entities.Product;
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

    @Override
    public void create(Product entity) throws EntityCannotBeAddedException {
        if(productDataStorage.getEntities().stream()
                .anyMatch(item -> item.getName().equalsIgnoreCase(entity.getName()))){

            throw new ProductCannotBeAddedException(entity.getName());
        }

        super.create(entity);
    }
}
