package by.exposit.storages;

import by.exposit.filemanager.FileManager;
import by.exposit.model.entities.BaseEntity;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDataStorage<T extends BaseEntity> {

  private long entityIdSequence;

  private Collection<T> entities;

  protected AbstractDataStorage(FileManager fileManager, String path,
      Class<? extends AbstractDataStorage<?>> type) {
    AbstractDataStorage<?> dataStorage = (AbstractDataStorage<?>) fileManager
        .deserialize(path, type);
    setEntities((Collection<T>) dataStorage.getEntities());
    setEntityIdSequence(dataStorage.getEntityIdSequence());
  }

  public long generateEntityId() {
    return entityIdSequence++;
  }
}
