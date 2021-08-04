package by.exposit.persistence.mappers;

import by.exposit.core.model.entities.User;
import by.exposit.persistence.entities.UserEntity;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

  UserEntity toPersistenceEntity(User user);

  User toEntity(UserEntity userEntity);

  Collection<UserEntity> toPersistenceEntityCollection(Collection<User> users);

  Collection<User> toEntityCollection(Collection<UserEntity> userEntityCollection);
}
