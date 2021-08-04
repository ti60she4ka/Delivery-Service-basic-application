package by.exposit.persistence.repositories.user;

import by.exposit.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

  boolean existsByUsername(String username);

  boolean existsByUsernameAndIdIsNot(String username, Long id);
}
