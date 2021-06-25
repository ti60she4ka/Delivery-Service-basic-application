package api.services;

import model.entities.Product;
import model.entities.ProductStorage;
import model.entities.Shop;
import model.enums.Category;

import java.util.EnumSet;
import java.util.List;

public interface ShopService extends AbstractService<Shop> {
    void updateProductInShops(Product product);

    void deleteProductFromShops(Product product);

    List<ProductStorage> getProductStoragesFromAllShops();

    List<ProductStorage> getAllProductStoragesByCategoriesContains(EnumSet<Category> categories);

    List<ProductStorage> getAllProductStoragesOrderByPrice();

    List<ProductStorage> getAllProductStoragesOrderByPriceDesc();
}
