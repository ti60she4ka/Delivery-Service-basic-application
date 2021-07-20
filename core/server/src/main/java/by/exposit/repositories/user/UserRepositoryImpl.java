package by.exposit.repositories.user;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.UserCannotBeAddedException;
import by.exposit.exceptions.UserNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.repositories.AbstractRepositoryImpl;
import by.exposit.storages.UserDataStorage;

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
