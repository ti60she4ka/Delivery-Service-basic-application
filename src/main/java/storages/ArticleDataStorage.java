package storages;

import lombok.Setter;
import model.entities.Article;

public class ArticleDataStorage extends AbstractDataStorage<Article> {
    @Setter
    private static ArticleDataStorage instance;

    private ArticleDataStorage(){}

    public static ArticleDataStorage getInstance(){
        if(instance == null){
            instance = new ArticleDataStorage();
        }

        return instance;
    }
}
