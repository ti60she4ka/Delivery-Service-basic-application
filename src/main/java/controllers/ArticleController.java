package controllers;

import api.services.ArticleService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import lombok.Setter;
import model.entities.Article;

import java.util.Collection;

public class ArticleController {
    private static ArticleController instance;
    @Setter
    private ArticleService articleService;

    private ArticleController(){
    }

    public static ArticleController getInstance() {
        if(instance == null){
            instance = new ArticleController();
        }

        return instance;
    }

    public void create(Article article) throws EntityCannotBeAddedException {
        articleService.create(article);
    }

    public Collection<Article> getAll(){
        return articleService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        articleService.deleteById(id);
    }

    public Article getById(long id) throws EntityNotFoundException {
        return articleService.getById(id);
    }
}
