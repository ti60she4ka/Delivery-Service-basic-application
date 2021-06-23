package controllers;

import api.services.ClientService;
import api.services.ShopService;
import exceptions.EntityNotFoundException;
import model.entities.Shop;
import services.ClientServiceImpl;
import services.ShopServiceImpl;

import java.util.List;

public class ShopController {
    private static ShopController instance;
    private ShopService shopService;

    private ShopController(){
        shopService = ShopServiceImpl.getInstance();
    }

    public static ShopController getInstance() {
        if(instance == null){
            instance = new ShopController();
        }

        return instance;
    }

    public void createShop(Shop shop){
        shopService.create(shop);
    }

    public List<Shop> getShops(){
        return shopService.getAll();
    }

    public void deleteShop(long id) throws EntityNotFoundException {
        shopService.delete(id);
    }

    public Shop getShop(long id) throws EntityNotFoundException {
        return shopService.get(id);
    }
}
