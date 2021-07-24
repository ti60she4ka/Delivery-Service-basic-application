package by.exposit.core.repositories;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.storages.AbstractDataStorage;
import java.util.Collection;

public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements
    AbstractRepository<T> {

  protected AbstractDataStorage<T> abstractDataStorage;
  protected String entityType;

  protected AbstractRepositoryImpl(AbstractDataStorage<T> abstractDataStorage) {
    this.abstractDataStorage = abstractDataStorage;
  }

  @Override
  public void create(T entity) throws EntityCannotBeAddedException {
    entity.setId(abstractDataStorage.generateEntityId());
    abstractDataStorage.getEntities().add(entity);
  }

  @Override
  public Collection<T> getAll() {
    return abstractDataStorage.getEntities();
  }

  @Override
  public void deleteById(Long id) throws EntityNotFoundException {
    T entityForDelete = abstractDataStorage.getEntities()
        .stream()
        .filter(entity -> entity.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(entityType, id));

    abstractDataStorage.getEntities().remove(entityForDelete);
  }

  @Override
  public T getById(Long id) throws EntityNotFoundException {
    return abstractDataStorage.getEntities()
        .stream()
        .filter(entity -> entity.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(entityType, id));
  }
}
