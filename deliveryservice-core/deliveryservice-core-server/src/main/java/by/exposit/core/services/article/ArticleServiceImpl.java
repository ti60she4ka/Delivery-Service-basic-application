package by.exposit.core.services.article;

import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.article.ArticleRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class ArticleServiceImpl extends AbstractServiceImpl<Article> implements ArticleService {

  private final ArticleRepository articleRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository) {
    super(articleRepository);
    this.articleRepository = articleRepository;
  }
}
