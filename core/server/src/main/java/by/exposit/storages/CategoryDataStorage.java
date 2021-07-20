package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.Category;

public class CategoryDataStorage extends AbstractDataStorage<Category> {

  public CategoryDataStorage(FileManager fileManager, String path,
      Class<CategoryDataStorage> type) {
    super(fileManager, path, type);
  }
}
