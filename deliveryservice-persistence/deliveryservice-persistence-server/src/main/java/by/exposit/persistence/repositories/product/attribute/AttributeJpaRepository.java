package by.exposit.persistence.repositories.product.attribute;

import by.exposit.persistence.entities.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeJpaRepository extends JpaRepository<AttributeEntity, Long> {

  void deleteAllByProductId(Long id);
}
