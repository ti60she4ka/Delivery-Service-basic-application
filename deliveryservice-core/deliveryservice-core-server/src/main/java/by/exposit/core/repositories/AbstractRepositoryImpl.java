package by.exposit.core.repositories;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.RepeatingEntityException;
import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.storages.AbstractDataStorage;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements
    AbstractRepository<T> {

  protected AbstractDataStorage<T> abstractDataStorage;
  protected String entityType;

  protected AbstractRepositoryImpl(AbstractDataStorage<T> abstractDataStorage) {
    this.abstractDataStorage = abstractDataStorage;
  }

  @Override
  public T create(T entity) throws EntityCannotBeAddedException {
    entity.setId(abstractDataStorage.generateEntityId());
    abstractDataStorage.getEntities().add(entity);

    abstractDataStorage.save();

    return entity;
  }

  @Override
  public Collection<T> getAll() {
    return abstractDataStorage.getEntities();
  }

  @Override
  public void deleteById(Long id) throws EntityNotFoundException, RepeatingEntityException {
    abstractDataStorage.getEntities().remove(getById(id));

    abstractDataStorage.save();
  }

  @Override
  public void update(T entity) throws EntityNotFoundException, RepeatingEntityException {
    abstractDataStorage.getEntities().remove(getById(entity.getId()));
    abstractDataStorage.getEntities().add(entity);

    abstractDataStorage.save();
  }

  @Override
  public T getById(Long id) throws EntityNotFoundException, RepeatingEntityException {
    List<T> entities = abstractDataStorage.getEntities()
        .stream()
        .filter(entity -> entity.getId().equals(id))
        .collect(Collectors.toList());

    if (entities.isEmpty()) {
      throw new EntityNotFoundException(entityType, id);
    } else if (entities.size() > 1) {
      throw new RepeatingEntityException(entityType, id);
    }

    return entities.get(0);
  }
}
