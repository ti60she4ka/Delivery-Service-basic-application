package by.exposit.core.services;

import by.exposit.core.model.entities.BaseEntity;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import java.util.Collection;

public interface AbstractService<T extends BaseEntity, E> {

  E create(E entity);

  Collection<E> getAll();

  void deleteById(Long id);

  void update(E entity);

  E getById(Long id);
}
