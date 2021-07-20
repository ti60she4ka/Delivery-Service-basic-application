package by.exposit.repositories.user;

import by.exposit.exceptions.UserNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.repositories.AbstractRepository;

public interface UserRepository extends AbstractRepository<User> {

  User get(User user) throws UserNotFoundException;
}
