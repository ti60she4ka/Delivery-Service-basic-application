package repositories;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import lombok.NoArgsConstructor;
import model.entities.BaseEntity;
import storages.AbstractDataStorage;

import java.util.Collection;

@NoArgsConstructor
public abstract class AbstractRepositoryImpl<T extends BaseEntity> implements AbstractRepository<T> {
    protected AbstractDataStorage<T> abstractDataStorage;
    protected String entityType;

    @Override
    public void create(T entity) throws EntityCannotBeAddedException {
        entity.setId(abstractDataStorage.generateEntityId());
        abstractDataStorage.getEntities().add(entity);
    }

    @Override
    public Collection<T> getAll() {
        return abstractDataStorage.getEntities();
    }

    @Override
    public void deleteById(long id) throws EntityNotFoundException {
        T entityForDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(entityType, id));

        abstractDataStorage.getEntities().remove(entityForDelete);
    }

    @Override
    public T getById(long id) throws EntityNotFoundException {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(entityType, id));
    }
}
