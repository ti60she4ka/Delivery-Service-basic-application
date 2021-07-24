package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.BaseEntity;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDataStorage<T extends BaseEntity> {

  private Long entityIdSequence;

  private Collection<T> entities;

  protected AbstractDataStorage(FileManager fileManager, String path,
      Class<? extends AbstractDataStorage<?>> type) {
    AbstractDataStorage<?> dataStorage = (AbstractDataStorage<?>) fileManager
        .deserialize(path, type);
    setEntities((Collection<T>) dataStorage.getEntities());
    setEntityIdSequence(dataStorage.getEntityIdSequence());

    if (entities == null) {
      entities = new ArrayList<>();
    }
    if (entityIdSequence == null) {
      entityIdSequence = 0L;
    }
  }

  public long generateEntityId() {
    return entityIdSequence++;
  }
}
