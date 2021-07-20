package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Article;
import by.exposit.services.article.ArticleService;
import java.util.Collection;

public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  public void create(Article article) throws EntityCannotBeAddedException {
    articleService.create(article);
  }

  public Collection<Article> getAll() {
    return articleService.getAll();
  }

  public void deleteById(long id) throws EntityNotFoundException {
    articleService.deleteById(id);
  }

  public Article getById(long id) throws EntityNotFoundException {
    return articleService.getById(id);
  }
}
