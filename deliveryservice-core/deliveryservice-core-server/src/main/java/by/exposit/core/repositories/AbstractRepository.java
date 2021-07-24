package by.exposit.core.repositories;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.BaseEntity;
import java.util.Collection;

public interface AbstractRepository<T extends BaseEntity> {

  void create(T entity) throws EntityCannotBeAddedException;

  Collection<T> getAll();

  void deleteById(Long id) throws EntityNotFoundException;

  T getById(Long id) throws EntityNotFoundException;
}
