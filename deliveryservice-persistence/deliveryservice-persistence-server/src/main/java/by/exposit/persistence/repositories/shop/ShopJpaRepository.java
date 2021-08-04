package by.exposit.persistence.repositories.shop;

import by.exposit.persistence.entities.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopJpaRepository extends JpaRepository<ShopEntity, Long> {

}
