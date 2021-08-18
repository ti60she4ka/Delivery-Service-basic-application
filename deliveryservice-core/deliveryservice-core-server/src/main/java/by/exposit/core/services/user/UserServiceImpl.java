package by.exposit.core.services.user;

import by.exposit.core.annotations.user.UserIdExists;
import by.exposit.core.annotations.user.UsernameNotOccupied;
import by.exposit.core.aspects.validation.Validate;
import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.UserDto;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.UserAlreadyExistsException;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.mappers.order.OrderMapper;
import by.exposit.core.mappers.user.UserMapper;
import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.UserRepository;
import by.exposit.core.services.AbstractServiceImpl;
import java.util.Collection;

public class UserServiceImpl extends AbstractServiceImpl<User, UserDto> implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final OrderMapper orderMapper;

  public UserServiceImpl(UserRepository userRepository, BaseMapper<User, UserDto> userMapper,
      OrderMapper orderMapper) {
    super(userRepository, userMapper);
    this.userRepository = userRepository;
    this.userMapper = (UserMapper) userMapper;
    this.orderMapper = orderMapper;
  }

  @Override
  @Validate
  public UserDto create(@UsernameNotOccupied UserDto userDto) {
    return super.create(userDto);
  }

  @Override
  @Validate
  public UserDto create(@UsernameNotOccupied UserDto userDto, String password, String role) {
    return mapper.toDto(userRepository.create(userMapper.toUserWithPasswordAndRole(userDto, password, role)));
  }

  @Override
  @Validate
  public void deleteById(@UserIdExists Long id) {
    super.deleteById(id);
  }

  @Override
  @Validate
  public void update(@UsernameNotOccupied UserDto userDto) {
    User user = mapper.toEntity(userDto);
    user.setVersion(getVersionByUserId(userDto.getId()));
    userRepository.update(user);
  }

  @Override
  @Validate
  public UserDto getById(@UserIdExists Long id) {
    return super.getById(id);
  }

  @Override
  @Validate
  public Collection<OrderDto> getOrdersByUserId(@UserIdExists Long id) {
    return orderMapper.toDtoCollection(userRepository.getOrdersByUserId(id));
  }

  private Long getVersionByUserId(Long id) {
    if (userRepository.existsById(id)) {
      return userRepository.getById(id).getVersion();
    } else {
      return 0L;
    }
  }
}
