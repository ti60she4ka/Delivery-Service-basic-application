package api.repositories;

import exceptions.UserNotFoundException;
import model.entities.User;

public interface UserRepository extends AbstractRepository<User>{
    User get(User user) throws UserNotFoundException;
}
