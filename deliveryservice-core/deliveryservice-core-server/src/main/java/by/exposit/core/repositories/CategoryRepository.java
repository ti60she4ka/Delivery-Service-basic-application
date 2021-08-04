package by.exposit.core.repositories;

import by.exposit.core.model.entities.Category;
import by.exposit.core.model.entities.Product;
import java.util.Collection;

public interface CategoryRepository extends AbstractRepository<Category> {

  Collection<Product> getProductsByCategoryId(Long id);

  boolean existsByName(String name);

  boolean existsByNameAndIdIsNot(String name, Long id);

  boolean existsById(Long id);
}
