package repositories;

import api.repositories.ArticleRepository;
import model.entities.Article;
import storages.ArticleDataStorage;

public class ArticleRepositoryImpl extends AbstractRepositoryImpl<Article> implements ArticleRepository {
    private static ArticleRepositoryImpl instance;
    private ArticleDataStorage articleDataStorage;

    private ArticleRepositoryImpl(){
    }

    public static ArticleRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArticleRepositoryImpl();
        }

        return instance;
    }

    public void setArticleDataStorage(ArticleDataStorage articleDataStorage) {
        this.articleDataStorage = articleDataStorage;
        abstractDataStorage = articleDataStorage;
        entityType = "Article";
    }
}
