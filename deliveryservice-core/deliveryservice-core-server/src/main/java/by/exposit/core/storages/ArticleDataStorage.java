package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.Article;

public class ArticleDataStorage extends AbstractDataStorage<Article> {

  public ArticleDataStorage(FileManager fileManager, String path,
      Class<ArticleDataStorage> type) {
    super(fileManager, path, type);
  }
}
