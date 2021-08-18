package by.exposit.core.services.shop;

import by.exposit.core.annotations.shop.ShopIdExists;
import by.exposit.core.aspects.validation.Validate;
import by.exposit.core.dto.ArticleDto;
import by.exposit.core.dto.ShopDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.article.ArticleMapper;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.Collection;

public class ShopServiceImpl extends AbstractServiceImpl<Shop, ShopDto> implements ShopService {

  private final ShopRepository shopRepository;
  private final ArticleMapper articleMapper;

  public ShopServiceImpl(ShopRepository shopRepository, BaseMapper<Shop, ShopDto> shopMapper,
      ArticleMapper articleMapper) {
    super(shopRepository, shopMapper);
    this.shopRepository = shopRepository;
    this.articleMapper = articleMapper;
  }

  @Override
  @Validate
  public void deleteById(@ShopIdExists Long id) {
    super.deleteById(id);
  }

  @Override
  public void update(ShopDto shopDto) {
    Shop shop = mapper.toEntity(shopDto);
    shop.setVersion(getVersionByShopId(shopDto.getId()));
    shopRepository.update(shop);
  }

  @Override
  @Validate
  public ShopDto getById(@ShopIdExists Long id) {
    return super.getById(id);
  }

  @Override
  @Validate
  public Collection<ArticleDto> getArticlesByShopId(@ShopIdExists Long id) {
    return articleMapper.toDtoCollection(shopRepository.getArticlesByShopId(id));
  }

  private Long getVersionByShopId(Long id) {
    if (shopRepository.existsById(id)) {
      return shopRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
