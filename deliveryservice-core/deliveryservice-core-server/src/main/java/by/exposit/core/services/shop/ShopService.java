package by.exposit.core.services.shop;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ShopDto;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.services.AbstractService;
import java.util.Collection;

public interface ShopService extends AbstractService<Shop, ShopDto> {

  Collection<ArticleDto> getArticlesByShopId(Long id);
}
