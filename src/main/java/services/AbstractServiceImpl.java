package services;

import api.repositories.AbstractRepository;
import api.services.AbstractService;
import exceptions.EntityNotFoundException;
import model.entities.BaseEntity;

import java.util.List;

public abstract class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {
    protected AbstractRepository<T> abstractRepository;

    AbstractServiceImpl(AbstractRepository<T> abstractRepository){
        this.abstractRepository = abstractRepository;
    }

    @Override
    public void create(T entity){
        abstractRepository.create(entity);
    }

    @Override
    public List<T> getAll(){
        return abstractRepository.getAll();
    }

    @Override
    public void delete(long id) throws EntityNotFoundException {
        abstractRepository.delete(id);
    }

    @Override
    public T get(long id) throws EntityNotFoundException {
        return abstractRepository.get(id);
    }
}
