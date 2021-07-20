package by.exposit.services;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.BaseEntity;
import java.util.Collection;

public interface AbstractService<T extends BaseEntity> {

  void create(T entity) throws EntityCannotBeAddedException;

  Collection<T> getAll();

  void deleteById(long id) throws EntityNotFoundException;

  T getById(long id) throws EntityNotFoundException;
}
