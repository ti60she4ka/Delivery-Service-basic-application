package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.Category;

public class CategoryDataStorage extends AbstractDataStorage<Category> {

  public CategoryDataStorage(FileManager fileManager, String path,
      Class<CategoryDataStorage> type) {
    super(fileManager, path, type);
  }
}
