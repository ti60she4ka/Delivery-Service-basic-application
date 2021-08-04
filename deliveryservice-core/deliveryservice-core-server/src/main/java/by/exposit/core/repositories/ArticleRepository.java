package by.exposit.core.repositories;

import by.exposit.core.dto.ArticleDto;
import by.exposit.core.model.entities.Article;
import java.util.Collection;

public interface ArticleRepository extends AbstractRepository<Article> {

  boolean existsById(Long id);
}
