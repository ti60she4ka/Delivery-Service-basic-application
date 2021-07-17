package repositories.shop;

import repositories.AbstractRepositoryImpl;
import model.entities.Shop;
import storages.ShopDataStorage;

public class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop> implements ShopRepository {
    private static ShopRepositoryImpl instance;
    private ShopDataStorage shopDataStorage;

    private ShopRepositoryImpl(){
    }

    public static ShopRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ShopRepositoryImpl();
        }

        return instance;
    }

    public void setShopDataStorage(ShopDataStorage shopDataStorage) {
        this.shopDataStorage = shopDataStorage;
        abstractDataStorage = shopDataStorage;
        entityType = "Shop";
    }
}