package by.exposit.core.repositories.user;

import by.exposit.core.model.entities.User;
import by.exposit.core.repositories.AbstractRepositoryImpl;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.UserCannotBeAddedException;
import by.exposit.core.exceptions.UserNotFoundException;
import by.exposit.core.storages.UserDataStorage;

public class UserRepositoryImpl extends AbstractRepositoryImpl<User> implements UserRepository {

  private final UserDataStorage userDataStorage;

  public UserRepositoryImpl(UserDataStorage userDataStorage) {
    super(userDataStorage);
    this.userDataStorage = userDataStorage;
    entityType = "User";
  }

  @Override
  public User get(User user) throws UserNotFoundException {
    return userDataStorage.getEntities().stream()
        .filter(item -> item.getFirstName().equalsIgnoreCase(user.getFirstName())
            && item.getLastName().equalsIgnoreCase(user.getLastName())
            && item.getEmail().equalsIgnoreCase(user.getEmail()))
        .findFirst()
        .orElseThrow(UserNotFoundException::new);
  }

  @Override
  public void create(User entity) throws EntityCannotBeAddedException {
    if (userDataStorage.getEntities().stream()
        .anyMatch(item -> item.getEmail().equalsIgnoreCase(entity.getEmail()))) {

      throw new UserCannotBeAddedException(entity.getEmail());
    }

    super.create(entity);
  }
}
