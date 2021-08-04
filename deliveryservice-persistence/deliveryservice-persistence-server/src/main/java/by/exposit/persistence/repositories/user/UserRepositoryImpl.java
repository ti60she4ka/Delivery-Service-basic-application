package by.exposit.persistence.repositories.user;

import by.exposit.core.model.entities.Order;
import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.UserRepository;
import by.exposit.persistence.mappers.OrderPersistenceMapper;
import by.exposit.persistence.mappers.UserPersistenceMapper;
import java.util.Collection;

public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userRepository;
  private final UserPersistenceMapper userMapper;
  private final OrderPersistenceMapper orderMapper;

  public UserRepositoryImpl(UserJpaRepository userRepository, UserPersistenceMapper userMapper,
      OrderPersistenceMapper orderMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.orderMapper = orderMapper;
  }

  @Override
  public User create(User user) {
    return userMapper.toEntity(userRepository.save(userMapper.toPersistenceEntity(user)));
  }

  @Override
  public Collection<User> getAll() {
    return userMapper.toEntityCollection(userRepository.findAll());
  }

  @Override
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public void update(User user) {
    userRepository.save(userMapper.toPersistenceEntity(user));
  }

  @Override
  public User getById(Long id) {
    return userMapper.toEntity(userRepository.getById(id));
  }

  @Override
  public Collection<Order> getOrdersByUserId(Long id) {
    return orderMapper.toEntityCollection(userRepository.getById(id).getOrders());
  }

  @Override
  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  @Override
  public boolean existsByUsernameAndIdIsNot(String username, Long id) {
    return userRepository.existsByUsernameAndIdIsNot(username, id);
  }

  @Override
  public boolean existsById(Long id) {
    return userRepository.existsById(id);
  }
}
