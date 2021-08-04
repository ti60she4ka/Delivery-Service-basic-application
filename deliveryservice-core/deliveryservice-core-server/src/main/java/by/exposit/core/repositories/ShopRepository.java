package by.exposit.core.repositories;

import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Shop;
import java.util.Collection;

public interface ShopRepository extends AbstractRepository<Shop> {

  Collection<Article> getArticlesByShopId(Long id);

  boolean existsById(Long id);
}
