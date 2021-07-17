package repositories.product;

import repositories.AbstractRepositoryImpl;
import exceptions.EntityCannotBeAddedException;
import exceptions.ProductCannotBeAddedException;
import model.entities.Product;
import storages.ProductDataStorage;

public class ProductRepositoryImpl extends AbstractRepositoryImpl<Product> implements ProductRepository {
    private static ProductRepositoryImpl instance;
    private ProductDataStorage productDataStorage;

    private ProductRepositoryImpl(){
    }

    public static ProductRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ProductRepositoryImpl();
        }

        return instance;
    }

    public void setProductDataStorage(ProductDataStorage productDataStorage) {
        this.productDataStorage = productDataStorage;
        abstractDataStorage = productDataStorage;
        entityType = "Product";
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
