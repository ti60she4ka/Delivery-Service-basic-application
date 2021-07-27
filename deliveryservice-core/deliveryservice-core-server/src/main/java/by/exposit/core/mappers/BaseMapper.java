package by.exposit.core.mappers;

import by.exposit.core.model.entities.BaseEntity;
import java.util.Collection;

public interface BaseMapper<T extends BaseEntity, E> {

  E toDto(T entity);

  T toEntity(E entityDto);

  Collection<E> toDtoCollection(Collection<T> entityCollection);

  Collection<T> toEntityCollection(Collection<E> entityDtoCollection);
}
