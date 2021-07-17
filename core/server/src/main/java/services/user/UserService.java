package services.user;

import services.AbstractService;
import exceptions.UserNotFoundException;
import model.entities.User;

public interface UserService extends AbstractService<User> {
    User get(User user) throws UserNotFoundException;
}
