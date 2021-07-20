package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.User;

public class UserDataStorage extends AbstractDataStorage<User> {

  public UserDataStorage(FileManager fileManager, String path,
      Class<UserDataStorage> type) {
    super(fileManager, path, type);
  }
}
