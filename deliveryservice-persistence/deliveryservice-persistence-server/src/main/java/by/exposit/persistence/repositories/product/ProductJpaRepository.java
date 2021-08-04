package by.exposit.persistence.repositories.product;

import by.exposit.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

  boolean existsByName(String name);

  boolean existsByNameAndIdIsNot(String name, Long id);
}
