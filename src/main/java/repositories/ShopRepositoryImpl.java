package repositories;

import api.repositories.ShopRepository;
import model.entities.Shop;
import storages.ClientDataStorage;
import storages.ShopDataStorage;

public class ShopRepositoryImpl extends AbstractRepositoryImpl<Shop> implements ShopRepository {
    private static ShopRepositoryImpl instance;
    private ShopDataStorage shopDataStorage;

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
}
