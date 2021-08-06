package by.exposit.persistence.repositories.user;

import by.exposit.core.model.entities.Order;
import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.UserRepository;
import by.exposit.persistence.mappers.OrderPersistenceMapper;
import by.exposit.persistence.mappers.UserPersistenceMapper;
import java.util.Collection;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional
  public User create(User user) {
    return userMapper.toEntity(userRepository.save(userMapper.toPersistenceEntity(user)));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<User> getAll() {
    return userMapper.toEntityCollection(userRepository.findAll());
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void update(User user) {
    userRepository.save(userMapper.toPersistenceEntity(user));
  }

  @Override
  @Transactional(readOnly = true)
  public User getById(Long id) {
    return userMapper.toEntity(userRepository.getById(id));
  }

  @Override
  @Transactional(readOnly = true)
  public Collection<Order> getOrdersByUserId(Long id) {
    return orderMapper.toEntityCollection(userRepository.getById(id).getOrders());
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsByUsernameAndIdIsNot(String username, Long id) {
    return userRepository.existsByUsernameAndIdIsNot(username, id);
  }

  @Override
  @Transactional(readOnly = true)
  public boolean existsById(Long id) {
    return userRepository.existsById(id);
  }
}
