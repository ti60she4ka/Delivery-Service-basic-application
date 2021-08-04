package by.exposit.persistence.repositories.category;

import by.exposit.persistence.entities.CategoryEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

  boolean existsByName(String name);

  boolean existsByNameAndIdIsNot(String name, Long id);

  Collection<CategoryEntity> findAllByParentCategoryId(Long id);
}
