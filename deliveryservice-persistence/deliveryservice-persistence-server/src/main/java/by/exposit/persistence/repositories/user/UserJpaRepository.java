package by.exposit.persistence.repositories.user;

import by.exposit.persistence.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findUserEntityByUsername(String username);

  boolean existsByUsername(String username);

  boolean existsByUsernameAndIdIsNot(String username, Long id);
}
