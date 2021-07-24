package by.exposit.core.repositories.article;

import by.exposit.core.model.entities.Article;
import by.exposit.core.repositories.AbstractRepositoryImpl;
import by.exposit.core.storages.ArticleDataStorage;

public class ArticleRepositoryImpl extends AbstractRepositoryImpl<Article>
    implements ArticleRepository {

  private final ArticleDataStorage articleDataStorage;

  public ArticleRepositoryImpl(ArticleDataStorage articleDataStorage) {
    super(articleDataStorage);
    this.articleDataStorage = articleDataStorage;
    entityType = "Article";
  }
}
