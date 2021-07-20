package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.Article;

public class ArticleDataStorage extends AbstractDataStorage<Article> {

  public ArticleDataStorage(FileManager fileManager, String path,
      Class<ArticleDataStorage> type) {
    super(fileManager, path, type);
  }
}
