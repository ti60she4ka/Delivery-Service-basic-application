package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Attribute;
import by.exposit.persistence.entities.AttributeEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributePersistenceMapper {

  AttributeEntity toPersistenceEntity(Attribute attribute);

  Attribute toEntity(AttributeEntity attributeEntity);

  Collection<AttributeEntity> toPersistenceEntityCollection(Collection<Attribute> attributes);

  Collection<Attribute> toEntityCollection(Collection<AttributeEntity> attributeEntityCollection);
}
