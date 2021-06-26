package services;

import api.repositories.AbstractRepository;
import api.services.AbstractService;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.BaseEntity;

import java.util.List;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {
    protected AbstractRepository<T> abstractRepository;

    protected AbstractServiceImpl(AbstractRepository<T> abstractRepository){
        this.abstractRepository = abstractRepository;
    }

    @Override
    public void create(T entity) throws EntityCannotBeAddedException {
        abstractRepository.create(entity);
    }

    @Override
    public List<T> getAll() {
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
