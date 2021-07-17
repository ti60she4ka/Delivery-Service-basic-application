package repositories.user;

import exceptions.UserNotFoundException;
import model.entities.User;
import repositories.AbstractRepository;

public interface UserRepository extends AbstractRepository<User> {
    User get(User user) throws UserNotFoundException;
}
