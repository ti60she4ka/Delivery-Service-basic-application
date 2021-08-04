package by.exposit.core.repositories;

import by.exposit.core.model.entities.Article;

public interface ArticleRepository extends AbstractRepository<Article> {

  boolean existsById(Long id);
}
