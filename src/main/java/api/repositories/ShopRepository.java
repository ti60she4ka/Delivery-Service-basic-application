package api.repositories;

import model.entities.Product;
import model.entities.Shop;

import java.util.List;

public interface ShopRepository extends AbstractRepository<Shop> {
    void deleteProductFromShops(Product product);

    void setAll(List<Shop> shops);
}
