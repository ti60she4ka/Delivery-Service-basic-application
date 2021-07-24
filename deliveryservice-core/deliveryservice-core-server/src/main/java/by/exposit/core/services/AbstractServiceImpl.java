package by.exposit.core.services;

import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.repositories.AbstractRepository;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
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
  public void deleteById(Long id) throws EntityNotFoundException {
    abstractRepository.deleteById(id);
  }

  @Override
  public T getById(Long id) throws EntityNotFoundException {
    return abstractRepository.getById(id);
  }
}
