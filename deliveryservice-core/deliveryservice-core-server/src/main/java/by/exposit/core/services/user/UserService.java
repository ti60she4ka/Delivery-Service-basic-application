package by.exposit.core.services.user;

import by.exposit.core.dto.OrderDto;
import by.exposit.core.dto.UserDto;
import by.exposit.core.model.entities.User;
import by.exposit.core.services.AbstractService;
import java.util.Collection;

public interface UserService extends AbstractService<User, UserDto> {

  Collection<OrderDto> getOrdersByUserId(Long id);
}
