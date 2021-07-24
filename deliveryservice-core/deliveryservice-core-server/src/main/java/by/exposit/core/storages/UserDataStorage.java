package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.User;

public class UserDataStorage extends AbstractDataStorage<User> {

  public UserDataStorage(FileManager fileManager, String path,
      Class<UserDataStorage> type) {
    super(fileManager, path, type);
  }
}
