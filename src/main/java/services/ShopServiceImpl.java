package services;

import api.repositories.ShopRepository;
import api.services.ShopService;
import model.entities.Product;
import model.entities.ProductStorage;
import model.entities.Shop;
import model.enums.Category;
import repositories.ShopRepositoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class ShopServiceImpl extends AbstractServiceImpl<Shop> implements ShopService {
    private static ShopServiceImpl instance;
    private final ShopRepository shopRepository;

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

    @Override
    public void updateProductInShops(Product product) {
        List<Shop> shops = shopRepository.getAll();

        for (Shop shop : shops){
            for (ProductStorage productStorage : shop.getProductStorages()){
                if(productStorage.getProduct().equals(product)){
                    productStorage.getProduct().setName(product.getName());
                    productStorage.getProduct().setCategories(product.getCategories());
                }
            }
        }
    }

    @Override
    public void deleteProductFromShops(Product product) {
        shopRepository.deleteProductFromShops(product);
    }

    @Override
    public List<ProductStorage> getAllProductStorages() {
        List<ProductStorage> productStorages = new ArrayList<>();
        shopRepository.getAll().forEach(shop -> productStorages.addAll(shop.getProductStorages()));

        return  productStorages;
    }

    @Override
    public List<ProductStorage> getAllProductStoragesByCategoriesContainsOneOf(EnumSet<Category> categories) {
        return getAllProductStorages().stream()
                .filter(item -> isProductContainsOneOfCategory(item.getProduct(), categories))
                .collect(Collectors.toList());
    }

    private boolean isProductContainsOneOfCategory(Product product, EnumSet<Category> categories){
        for (Category category : categories){
            if(product.getCategories().contains(category)){
                return true;
            }
        }

        return false;
    }

    @Override
    public List<ProductStorage> getAllProductStoragesOrderByPrice() {
        return getAllProductStorages().stream()
                .sorted(Comparator.comparingDouble(item -> item.getProduct().getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductStorage> getAllProductStoragesOrderByPriceDesc() {
        return getAllProductStorages().stream()
                .sorted((item1, item2) -> Double.compare(item2.getProduct().getPrice(), item1.getProduct().getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void setAll(List<Shop> shops) {
        shopRepository.setAll(shops);
    }
}
