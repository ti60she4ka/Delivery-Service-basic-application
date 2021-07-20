package by.exposit.services.article;

import by.exposit.model.entities.Article;
import by.exposit.repositories.article.ArticleRepository;
import by.exposit.services.AbstractServiceImpl;

public class ArticleServiceImpl extends AbstractServiceImpl<Article> implements ArticleService {

  private final ArticleRepository articleRepository;

  public ArticleServiceImpl(ArticleRepository articleRepository) {
    super(articleRepository);
    this.articleRepository = articleRepository;
  }
}
