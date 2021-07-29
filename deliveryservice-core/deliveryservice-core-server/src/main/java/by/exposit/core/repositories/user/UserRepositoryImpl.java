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
}
