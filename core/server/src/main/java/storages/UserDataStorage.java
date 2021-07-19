package storages;

import lombok.Setter;
import model.entities.User;

public class UserDataStorage extends AbstractDataStorage<User> {

  @Setter
  private static UserDataStorage instance;

  private UserDataStorage() {
  }

  public static UserDataStorage getInstance() {
    if (instance == null) {
      instance = new UserDataStorage();
    }

    return instance;
  }
}
