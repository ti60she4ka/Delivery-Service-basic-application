package by.exposit.core.services.user;

import by.exposit.core.dto.UserDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.User;
import by.exposit.core.exceptions.UserNotFoundException;
import by.exposit.core.repositories.user.UserRepository;
import by.exposit.core.services.AbstractServiceImpl;

public class UserServiceImpl extends AbstractServiceImpl<User, UserDto> implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository, BaseMapper<User, UserDto> mapper) {
    super(userRepository, mapper);
    this.userRepository = userRepository;
  }
}
