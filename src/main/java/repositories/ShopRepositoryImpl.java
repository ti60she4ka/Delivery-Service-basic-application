package repositories;

import api.repositories.ShopRepository;
import model.entities.Product;
import model.entities.Shop;
import storages.ShopDataStorage;

import java.util.List;

public class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop> implements ShopRepository {
    private static ShopRepositoryImpl instance;
    private final ShopDataStorage shopDataStorage;

    private ShopRepositoryImpl(){
        super(ShopDataStorage.getInstance());
        shopDataStorage = (ShopDataStorage) abstractDataStorage;
        entityType = "Shop";
    }

    public static ShopRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ShopRepositoryImpl();
        }

        return instance;
    }

    @Override
    public void deleteProductFromShops(Product product) {
        for (Shop shop : shopDataStorage.getEntities()){
            shop.getProductStorages().removeIf(productStorage -> productStorage.getProduct().equals(product));
        }
    }

    @Override
    public void setAll(List<Shop> shops) {
        shopDataStorage.setEntities(shops);
    }
}
