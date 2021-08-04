package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.Shop;
import by.exposit.core.model.entities.User;
import by.exposit.persistence.entities.ShopEntity;
import by.exposit.persistence.entities.UserEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopPersistenceMapper {

  ShopEntity toPersistenceEntity(Shop shop);

  Shop toEntity(ShopEntity shopEntity);

  Collection<ShopEntity> toPersistenceEntityCollection(Collection<Shop> shops);

  Collection<Shop> toEntityCollection(Collection<ShopEntity> shopEntityCollection);
}
