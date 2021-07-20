package by.exposit.services.user;

import by.exposit.exceptions.UserNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.repositories.user.UserRepository;
import by.exposit.services.AbstractServiceImpl;

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
