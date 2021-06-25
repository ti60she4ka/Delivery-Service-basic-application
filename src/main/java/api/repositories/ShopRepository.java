package api.repositories;

import model.entities.Product;
import model.entities.Shop;

public interface ShopRepository extends AbstractRepository<Shop> {
    void deleteProductFromShops(Product product);
}
