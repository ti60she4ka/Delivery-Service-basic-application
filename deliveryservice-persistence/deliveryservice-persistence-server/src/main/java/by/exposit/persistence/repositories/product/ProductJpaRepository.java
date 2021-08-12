package by.exposit.persistence.repositories.product;

import by.exposit.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long>,
    JpaSpecificationExecutor<ProductEntity> {

  boolean existsByName(String name);

  boolean existsByNameAndIdIsNot(String name, Long id);
}
