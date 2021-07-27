package by.exposit.core.services.article;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.article.ArticleRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ArticleServiceImpl extends AbstractServiceImpl<Article, ArticleDto> implements ArticleService {

  private final ArticleRepository articleRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository, BaseMapper<Article, ArticleDto> mapper) {
    super(articleRepository, mapper);
    this.articleRepository = articleRepository;
  }
}
