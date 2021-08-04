package by.exposit.core.services.user;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.UserDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.UserAlreadyExistsException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.order.OrderMapper;
import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.UserRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.Collection;

public class UserServiceImpl extends AbstractServiceImpl<User, UserDto> implements UserService {

  private final UserRepository userRepository;
  private final OrderMapper orderMapper;

  public UserServiceImpl(UserRepository userRepository, BaseMapper<User, UserDto> userMapper,
      OrderMapper orderMapper) {
    super(userRepository, userMapper);
    this.userRepository = userRepository;
    this.orderMapper = orderMapper;
    entityType = "User";
  }

  @Override
  public UserDto create(UserDto userDto) {
    if (!userRepository.existsByUsername(userDto.getUsername())) {
      return super.create(userDto);
    } else {
      throw new UserAlreadyExistsException(userDto.getUsername());
    }
  }

  @Override
  public void deleteById(Long id) {
    if (userRepository.existsById(id)) {
      super.deleteById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public void update(UserDto userDto) {
    if (!userRepository.existsByUsernameAndIdIsNot(userDto.getUsername(), userDto.getId())) {
      super.update(userDto);
    } else {
      throw new UserAlreadyExistsException(userDto.getUsername());
    }
  }

  @Override
  public UserDto getById(Long id) {
    if (userRepository.existsById(id)) {
      return super.getById(id);
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }

  @Override
  public Collection<OrderDto> getOrdersByUserId(Long id) {
    if (userRepository.existsById(id)) {
      return orderMapper.toDtoCollection(userRepository.getOrdersByUserId(id));
    } else {
      throw new EntityNotFoundException(entityType, id);
    }
  }
}
