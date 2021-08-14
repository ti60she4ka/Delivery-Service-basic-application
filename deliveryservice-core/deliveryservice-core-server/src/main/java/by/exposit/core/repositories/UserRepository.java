package by.exposit.core.repositories;

import by.exposit.core.model.entities.Order;
import by.exposit.core.model.entities.User;
import java.util.Collection;
import java.util.Optional;

public interface UserRepository extends AbstractRepository<User> {

  Optional<User> findUserByUsername(String username);

  Collection<Order> getOrdersByUserId(Long id);

  boolean existsByUsername(String username);

  boolean existsByUsernameAndIdIsNot(String username, Long id);

  boolean existsById(Long id);
}
