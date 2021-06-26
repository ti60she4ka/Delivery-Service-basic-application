package controllers;

import api.services.ShopService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.Product;
import model.entities.ProductStorage;
import model.entities.Shop;
import model.enums.Category;
import model.enums.SortType;
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

    public void create(Shop shop) throws EntityCannotBeAddedException {
        shopService.create(shop);
    }

    public List<Shop> getAll(){
        return shopService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        shopService.deleteById(id);
    }

    public Shop getById(long id) throws EntityNotFoundException {
        return shopService.getById(id);
    }

    public void updateProductInShops(Product product){
        shopService.updateProductInShops(product);
    }

    public void deleteProductFromShops(Product product){
        shopService.deleteProductFromShops(product);
    }

    public List<ProductStorage> getAllProductStorages(){
        return shopService.getAllProductStorages();
    }

    public List<ProductStorage> getAllProductStoragesByCategoriesContains(EnumSet<Category> categories){
        return shopService.getAllProductStoragesByCategoriesContainsOneOf(categories);
    }

    public List<ProductStorage> getAllProductStoragesOrderByPrice(SortType sortType){
        switch (sortType){
            case ASCENDING:
                return shopService.getAllProductStoragesOrderByPrice();
            case DESCENDING:
                return shopService.getAllProductStoragesOrderByPriceDesc();
        }

        return null;
    }

    public void setAll(List<Shop> shops){
        shopService.setAll(shops);
    }
}
