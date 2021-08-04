package by.exposit.web.mappers;

import by.exposit.core.dto.UserDto;
import by.exposit.web.requests.UserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {

  UserDto toDto(UserRequest userRequest);

  UserDto toDtoWithId(UserRequest userRequest, Long id);
}
