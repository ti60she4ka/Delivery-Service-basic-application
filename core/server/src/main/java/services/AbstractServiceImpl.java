package services;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import java.util.Collection;
import lombok.NoArgsConstructor;
import model.entities.BaseEntity;
import repositories.AbstractRepository;

@NoArgsConstructor
public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

  protected AbstractRepository<T> abstractRepository;

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
