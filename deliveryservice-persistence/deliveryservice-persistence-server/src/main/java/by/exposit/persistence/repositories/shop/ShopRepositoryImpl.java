package by.exposit.persistence.repositories.shop;

import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Shop;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.persistence.mappers.ArticlePersistenceMapper;
import by.exposit.persistence.mappers.ShopPersistenceMapper;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional
  public Shop create(Shop shop) {
    return shopMapper.toEntity(shopRepository.save(shopMapper.toPersistenceEntity(shop)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Shop> getAll() {
    return shopMapper.toEntityCollection(shopRepository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    shopRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(Shop shop) {
    shopRepository.save(shopMapper.toPersistenceEntity(shop));
  }

  @Override
  @Transactional(readOnly = true)
  public Shop getById(Long id) {
    return shopMapper.toEntity(shopRepository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Article> getArticlesByShopId(Long id) {
    return articleMapper.toEntityCollection(shopRepository.getById(id).getArticles());
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return shopRepository.existsById(id);
  }
}
