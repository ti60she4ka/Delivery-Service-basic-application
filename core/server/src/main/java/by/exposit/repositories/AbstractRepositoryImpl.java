package by.exposit.repositories;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.BaseEntity;
import by.exposit.storages.AbstractDataStorage;
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
  public void deleteById(long id) throws EntityNotFoundException {
    T entityForDelete = abstractDataStorage.getEntities()
        .stream()
        .filter(entity -> entity.getId() == id)
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(entityType, id));

    abstractDataStorage.getEntities().remove(entityForDelete);
  }

  @Override
  public T getById(long id) throws EntityNotFoundException {
    return abstractDataStorage.getEntities()
        .stream()
        .filter(entity -> entity.getId() == id)
        .findFirst()
        .orElseThrow(() -> new EntityNotFoundException(entityType, id));
  }
}
