package storages;

import model.entities.Shop;

public class ShopDataStorage extends AbstractDataStorage<Shop> {
    private static ShopDataStorage instance;

    private ShopDataStorage(){}

    public static ShopDataStorage getInstance(){
        if(instance == null){
            instance = new ShopDataStorage();
        }

        return instance;
    }

    public static void setInstance(ShopDataStorage instance) {
        ShopDataStorage.instance = instance;
    }
}
