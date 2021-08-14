package by.exposit.core.mappers.user;

import by.exposit.core.dto.UserDto;
import by.exposit.core.mappers.BaseMapper;
import by.exposit.core.model.entities.User;
import by.exposit.core.model.enums.user.Role;
import java.util.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Override
  UserDto toDto(User user);

  @Override
  User toEntity(UserDto userDto);

  @Mapping(target = "role", source = "role", qualifiedByName = "stringRoleToRole")
  User toUserWithPasswordAndRole(UserDto userDto, String password, String role);

  @Override
  Collection<UserDto> toDtoCollection(Collection<User> userCollection);

  @Override
  Collection<User> toEntityCollection(Collection<UserDto> userDtoCollection);

  @Named("stringRoleToRole")
  default Role stringRoleToRole(String role) {
    if (role == null) {
      return null;
    }

    return Role.valueOf(role);
  }
}
