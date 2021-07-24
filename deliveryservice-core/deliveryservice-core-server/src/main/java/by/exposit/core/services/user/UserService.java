package by.exposit.core.services.user;

import by.exposit.core.model.entities.User;
import by.exposit.core.exceptions.UserNotFoundException;
import by.exposit.core.services.AbstractService;

public interface UserService extends AbstractService<User> {

  User get(User user) throws UserNotFoundException;
}
