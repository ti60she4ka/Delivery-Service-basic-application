package by.exposit.repositories.article;

import by.exposit.model.entities.Article;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.ArticleDataStorage;

public class ArticleRepositoryImpl extends AbstractRepositoryImpl<Article>
    implements ArticleRepository {

  private final ArticleDataStorage articleDataStorage;

  public ArticleRepositoryImpl(ArticleDataStorage articleDataStorage) {
    super(articleDataStorage);
    this.articleDataStorage = articleDataStorage;
    entityType = "Article";
  }
}
