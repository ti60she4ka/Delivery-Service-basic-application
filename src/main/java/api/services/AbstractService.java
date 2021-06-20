package api.services;

import exceptions.EntityNotFoundException;
import model.entities.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseEntity> {
    void create(T entity);

    List<T> getAll();

    void delete(long id) throws EntityNotFoundException;

    T get(long id) throws EntityNotFoundException;
}
