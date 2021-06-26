package storages;

import lombok.Setter;
import model.entities.Shop;

public class ShopDataStorage extends AbstractDataStorage<Shop> {
    @Setter
    private static ShopDataStorage instance;

    private ShopDataStorage(){}

    public static ShopDataStorage getInstance(){
        if(instance == null){
            instance = new ShopDataStorage();
        }

        return instance;
    }
}
