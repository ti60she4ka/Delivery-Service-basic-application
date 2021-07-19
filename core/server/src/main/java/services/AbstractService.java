package services;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import java.util.Collection;
import model.entities.BaseEntity;

public interface AbstractService<T extends BaseEntity> {

  void create(T entity) throws EntityCannotBeAddedException;

  Collection<T> getAll();

  void deleteById(long id) throws EntityNotFoundException;

  T getById(long id) throws EntityNotFoundException;
}
