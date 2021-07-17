package controllers;

import services.shop.ShopService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import lombok.Setter;
import model.entities.Shop;

import java.util.Collection;

public class ShopController {
    private static ShopController instance;
    @Setter
    private ShopService shopService;

    private ShopController(){
    }

    public static ShopController getInstance() {
        if(instance == null){
            instance = new ShopController();
        }

        return instance;
    }

    public void create(Shop shop) throws EntityCannotBeAddedException {
        shopService.create(shop);
    }

    public Collection<Shop> getAll(){
        return shopService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        shopService.deleteById(id);
    }

    public Shop getById(long id) throws EntityNotFoundException {
        return shopService.getById(id);
    }
}
