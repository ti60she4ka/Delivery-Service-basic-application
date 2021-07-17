package services.shop;

import repositories.shop.ShopRepository;
import services.AbstractServiceImpl;
import model.entities.Shop;

public class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {
    private static ShopServiceImpl instance;
    private ShopRepository shopRepository;

    private ShopServiceImpl(){
    }

    public static ShopServiceImpl getInstance(){
        if(instance == null){
            instance = new ShopServiceImpl();
        }

        return instance;
    }

    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
        abstractRepository = shopRepository;
    }
}
