package by.exposit.core.services.article;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.ArticleRepository;
import by.exposit.core.repositories.ProductRepository;
import by.exposit.core.repositories.ShopRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ArticleServiceImpl extends AbstractServiceImpl<Article, ArticleDto> implements
    ArticleService {

  private final ArticleRepository articleRepository;
  private final ShopRepository shopRepository;
  private final ProductRepository productRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository, ShopRepository shopRepository,
      ProductRepository productRepository, BaseMapper<Article, ArticleDto> mapper) {
    super(articleRepository, mapper);
    this.articleRepository = articleRepository;
    this.shopRepository = shopRepository;
    this.productRepository = productRepository;
    entityType = "Article";
  }

  @Override
  public ArticleDto create(ArticleDto articleDto) {
    return mapper.toDto(articleRepository.create(mapToArticle(articleDto)));
  }

  @Override
  public void deleteById(Long id) {
    if (articleRepository.existsById(id)) {
      super.deleteById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public void update(ArticleDto articleDto) {
    Article article = mapToArticle(articleDto);
    article.setVersion(getVersionByArticleId(articleDto.getId()));
    articleRepository.update(article);
  }

  @Override
  public ArticleDto getById(Long id) {
    if (articleRepository.existsById(id)) {
      return super.getById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  private Article mapToArticle(ArticleDto articleDto) {
    Article article = mapper.toEntity(articleDto);

    if (shopRepository.existsById(articleDto.getShop().getId())) {
      article.setShop(shopRepository.getById(articleDto.getShop().getId()));
    } else {
      throw new EntityNotFoundException("Shop", articleDto.getShop().getId());
    }

    if (productRepository.existsById(articleDto.getProduct().getId())) {
      article.setProduct(productRepository.getById(articleDto.getProduct().getId()));
    } else {
      throw new EntityNotFoundException("Product", articleDto.getProduct().getId());
    }

    return article;
  }

  private Long getVersionByArticleId(Long id) {
    if (articleRepository.existsById(id)) {
      return articleRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
