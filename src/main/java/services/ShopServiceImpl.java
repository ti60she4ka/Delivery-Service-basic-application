package services;

import api.repositories.ClientRepository;
import api.repositories.ShopRepository;
import api.services.ShopService;
import model.entities.Shop;
import repositories.ClientRepositoryImpl;
import repositories.ShopRepositoryImpl;

public class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {
    private static ShopServiceImpl instance;
    private ShopRepository shopRepository;

    private ShopServiceImpl(){
        super(ShopRepositoryImpl.getInstance());
        shopRepository = (ShopRepository) abstractRepository;
    }

    public static ShopServiceImpl getInstance(){
        if(instance == null){
            instance = new ShopServiceImpl();
        }

        return instance;
    }
}
