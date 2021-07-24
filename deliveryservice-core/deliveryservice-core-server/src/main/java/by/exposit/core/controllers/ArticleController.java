package by.exposit.core.controllers;

import by.exposit.core.model.entities.Article;
import by.exposit.core.services.article.ArticleService;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
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

  public void deleteById(Long id) throws EntityNotFoundException {
    articleService.deleteById(id);
  }

  public Article getById(Long id) throws EntityNotFoundException {
    return articleService.getById(id);
  }
}
