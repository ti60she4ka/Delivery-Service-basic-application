package services.user;

import exceptions.UserNotFoundException;
import model.entities.User;
import services.AbstractService;

public interface UserService extends AbstractService<User> {

  User get(User user) throws UserNotFoundException;
}
