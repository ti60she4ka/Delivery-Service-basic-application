package repositories;

import api.repositories.AbstractRepository;
import exceptions.EntityNotFoundException;
import model.entities.BaseEntity;
import storages.AbstractDataStorage;

import java.util.List;

public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements AbstractRepository<T> {
    protected AbstractDataStorage<T> abstractDataStorage;
    protected String entityType;

    AbstractRepositoryImpl(AbstractDataStorage<T> dataStorage){
        abstractDataStorage = dataStorage;
    }

    @Override
    public void create(T entity){
        entity.setId(abstractDataStorage.generateEntityId());
        abstractDataStorage.getEntities().add(entity);
    }

    @Override
    public List<T> getAll(){
        return abstractDataStorage.getEntities();
    }

    @Override
    public void delete(long id) throws EntityNotFoundException {
        T entityForDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(entityType, id));

        abstractDataStorage.getEntities().remove(entityForDelete);
    }

    @Override
    public T get(long id) throws EntityNotFoundException {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(entityType, id));
    }
}
