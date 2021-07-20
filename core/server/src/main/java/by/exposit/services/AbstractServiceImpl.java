package by.exposit.services;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.BaseEntity;
import by.exposit.repositories.AbstractRepository;
import java.util.Collection;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

  protected AbstractRepository<T> abstractRepository;

  protected AbstractServiceImpl(AbstractRepository<T> abstractRepository) {
    this.abstractRepository = abstractRepository;
  }

  @Override
  public void create(T entity) throws EntityCannotBeAddedException {
    abstractRepository.create(entity);
  }

  @Override
  public Collection<T> getAll() {
    return abstractRepository.getAll();
  }

  @Override
  public void deleteById(long id) throws EntityNotFoundException {
    abstractRepository.deleteById(id);
  }

  @Override
  public T getById(long id) throws EntityNotFoundException {
    return abstractRepository.getById(id);
  }
}
