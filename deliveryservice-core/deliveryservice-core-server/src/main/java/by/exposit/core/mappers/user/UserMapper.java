package by.exposit.core.mappers.user;

import by.exposit.core.dto.UserDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.User;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {

  @Override
  UserDto toDto(User user);

  @Override
  User toEntity(UserDto userDto);

  @Override
  Collection<UserDto> toDtoCollection(Collection<User> userCollection);

  @Override
  Collection<User> toEntityCollection(Collection<UserDto> userDtoCollection);
}