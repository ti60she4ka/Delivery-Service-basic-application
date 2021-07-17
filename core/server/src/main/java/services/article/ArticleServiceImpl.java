package services.article;

import repositories.article.ArticleRepository;
import services.AbstractServiceImpl;
import model.entities.Article;

public class ArticleServiceImpl extends AbstractServiceImpl<Article> implements ArticleService {
    private static ArticleServiceImpl instance;
    private ArticleRepository articleRepository;

    private ArticleServiceImpl(){
    }

    public static ArticleServiceImpl getInstance(){
        if(instance == null){
            instance = new ArticleServiceImpl();
        }

        return instance;
    }

    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
        abstractRepository = articleRepository;
    }
}