package api.repositories;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.BaseEntity;

import java.util.List;

public interface AbstractRepository<T extends BaseEntity> {
    void create(T entity) throws EntityCannotBeAddedException;

    List<T> getAll();

    void deleteById(long id) throws EntityNotFoundException;

    T getById(long id) throws EntityNotFoundException;
}
