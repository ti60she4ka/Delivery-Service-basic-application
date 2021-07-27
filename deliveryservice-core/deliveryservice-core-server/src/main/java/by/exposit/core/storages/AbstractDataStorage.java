package by.exposit.core.storages;

import by.exposit.core.filemanager.FileManager;
import by.exposit.core.model.entities.BaseEntity;
import java.util.ArrayList;
import java.util.Collection;
import lombok.Getter;
import lombok.Setter;

public abstract class AbstractDataStorage<T extends BaseEntity> {

  @Getter
  @Setter
  private Long entityIdSequence;

  @Getter
  @Setter
  private Collection<T> entities;

  private final transient FileManager fileManager;
  private final transient String path;
  private final transient Class<? extends AbstractDataStorage<?>> type;

  protected AbstractDataStorage(FileManager fileManager, String path,
      Class<? extends AbstractDataStorage<?>> type) {
    this.fileManager = fileManager;
    this.path = path;
    this.type = type;

    load();

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

  public void save() {
    fileManager.serialize(type.cast(this), path, type);
  }

  private void load() {
    AbstractDataStorage<?> dataStorage = (AbstractDataStorage<?>) fileManager
        .deserialize(path, type);
    setEntities((Collection<T>) dataStorage.getEntities());
    setEntityIdSequence(dataStorage.getEntityIdSequence());
  }
}
