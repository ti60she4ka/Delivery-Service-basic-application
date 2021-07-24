package by.exposit.core.services.user;

import by.exposit.core.model.entities.User;
import by.exposit.core.exceptions.UserNotFoundException;
import by.exposit.core.repositories.user.UserRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    super(userRepository);
    this.userRepository = userRepository;
  }

  @Override
  public User get(User user) throws UserNotFoundException {
    return userRepository.get(user);
  }
}
