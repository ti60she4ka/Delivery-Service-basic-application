package by.exposit.persistence.repositories.shop;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.exceptions.EntityAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import by.exposit.persistence.mappers.ShopPersistenceMapper;
import java.util.Collection;

public class ShopRepositoryImpl implements ShopRepository {

  private final ShopJpaRepository shopRepository;
  private final ShopPersistenceMapper shopMapper;
  private final ArticlePersistenceMapper articleMapper;

  public ShopRepositoryImpl(ShopJpaRepository shopRepository, ShopPersistenceMapper shopMapper,
      ArticlePersistenceMapper articleMapper) {
    this.shopRepository = shopRepository;
    this.shopMapper = shopMapper;
    this.articleMapper = articleMapper;
  }

  @Override
  public Shop create(Shop shop) {
    return shopMapper.toEntity(shopRepository.save(shopMapper.toPersistenceEntity(shop)));
  }

  @Override
  public Collection<Shop> getAll() {
    return shopMapper.toEntityCollection(shopRepository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    shopRepository.deleteById(id);
  }

  @Override
  public void update(Shop shop) {
    shopRepository.save(shopMapper.toPersistenceEntity(shop));
  }

  @Override
  public Shop getById(Long id) {
    return shopMapper.toEntity(shopRepository.getById(id));
  }

  @Override
  public Collection<Article> getArticlesByShopId(Long id) {
    return articleMapper.toEntityCollection(shopRepository.getById(id).getArticles());
  }

  @Override
  public boolean existsById(Long id) {
    return shopRepository.existsById(id);
  }
}
