package storages;

import lombok.Getter;
import lombok.Setter;
import model.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataStorage<T extends BaseEntity> {
    private long entityIdSequence;
    @Getter
    @Setter
    private List<T> entities = new ArrayList<>();

    public long generateEntityId(){
        return entityIdSequence++;
    }
}
