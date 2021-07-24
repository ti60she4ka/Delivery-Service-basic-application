package by.exposit.core.services;

import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import java.util.Collection;

public interface AbstractService<T extends BaseEntity> {

  void create(T entity) throws EntityCannotBeAddedException;

  Collection<T> getAll();

  void deleteById(Long id) throws EntityNotFoundException;

  T getById(Long id) throws EntityNotFoundException;
}
