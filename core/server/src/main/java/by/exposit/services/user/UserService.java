package by.exposit.services.user;

import by.exposit.exceptions.UserNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.services.AbstractService;

public interface UserService extends AbstractService<User> {

  User get(User user) throws UserNotFoundException;
}
