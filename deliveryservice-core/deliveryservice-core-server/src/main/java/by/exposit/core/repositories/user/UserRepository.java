package by.exposit.core.repositories.user;

import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.AbstractRepository;
import by.exposit.core.exceptions.UserNotFoundException;

public interface UserRepository extends AbstractRepository<User> {

  User get(User user) throws UserNotFoundException;
}
