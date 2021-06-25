package controllers;

import api.services.ClientService;
import api.services.ShopService;
import exceptions.EntityNotFoundException;
import model.entities.Product;
import model.entities.ProductStorage;
import model.entities.Shop;
import model.enums.Category;
import services.ClientServiceImpl;
import services.ShopServiceImpl;

import java.util.EnumSet;
import java.util.List;

public class ShopController {
    private static ShopController instance;
    private final ShopService shopService;

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

    public void updateProductInShops(Product product){
        shopService.updateProductInShops(product);
    }

    public void deleteProductFromShops(Product product){
        shopService.deleteProductFromShops(product);
    }

    public List<ProductStorage> getAllProductStorages(){
        return shopService.getProductStoragesFromAllShops();
    }

    public List<ProductStorage> getAllProductStoragesByCategoriesContains(EnumSet<Category> categories){
        return shopService.getAllProductStoragesByCategoriesContains(categories);
    }

    public List<ProductStorage> getAllProductStoragesOrderByPrice(){
        return shopService.getAllProductStoragesOrderByPrice();
    }
}
