package by.exposit.core.repositories;

import by.exposit.core.model.entities.BaseEntity;
import java.util.Collection;

public interface AbstractRepository<T extends BaseEntity> {

  T create(T entity);

  Collection<T> getAll();

  void deleteById(Long id);

  void update(T entity);

  T getById(Long id);
}
