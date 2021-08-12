package by.exposit.core.repositories;

import by.exposit.core.filter.specifications.ProductSpecificationFilter;
import by.exposit.core.model.entities.Article;
import by.exposit.core.model.entities.Product;
import java.util.Collection;

public interface ProductRepository extends AbstractRepository<Product> {

  Collection<Product> getAll(ProductSpecificationFilter filter);

  Collection<Article> getArticlesByProductId(Long id);

  boolean existsByName(String name);

  boolean existsByNameAndIdIsNot(String name, Long id);

  boolean existsById(Long id);
}
