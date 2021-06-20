package storages;

import model.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataStorage<T extends BaseEntity> {
    private long entityIdSequence;
    private List<T> entities = new ArrayList<>();

    public long generateEntityId(){
        return entityIdSequence++;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
}
