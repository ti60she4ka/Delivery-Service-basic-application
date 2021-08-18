package by.exposit.core.aspects.validation;

import by.exposit.core.annotations.user.UserIdExists;
import by.exposit.core.annotations.user.UsernameNotOccupied;
import by.exposit.core.dto.CategoryDto;
import by.exposit.core.dto.UserDto;
import by.exposit.core.exceptions.CategoryAlreadyExistsException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.exceptions.UserAlreadyExistsException;
import by.exposit.core.repositories.UserRepository;
import java.lang.reflect.Parameter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
public class UserServiceValidationAspect {

  private final UserRepository userRepository;

  private static final String ENTITY_TYPE = "User";

  public UserServiceValidationAspect(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Pointcut(value = "execution(* by.exposit.core.services.user.UserServiceImpl.*(..))")
  public void anyMethodInUserService() {
  }

  @Before("anyMethodInUserService() && @annotation(Validate)")
  public void validateUserServiceParameters(JoinPoint joinPoint) {
    Object[] args = joinPoint.getArgs();
    Parameter[] parameters = ((MethodSignature) joinPoint.getSignature()).getMethod()
        .getParameters();

    for (int i = 0; i < parameters.length; i++) {
      if (parameters[i].isAnnotationPresent(UserIdExists.class)
          && parameters[i].getType() == Long.class) {

        executeUserIdExistsLogic((Long) args[i]);
      }

      if (parameters[i].isAnnotationPresent(UsernameNotOccupied.class)
          && parameters[i].getType() == UserDto.class) {

        executeUsernameNotOccupiedLogic((UserDto) args[i]);
      }
    }
  }

  private void executeUserIdExistsLogic(Long id) {
    if (!userRepository.existsById(id)) {
      throw new EntityNotFoundException(ENTITY_TYPE, id);
    }
  }

  private void executeUsernameNotOccupiedLogic(UserDto userDto) {
    if (userDto.getId() == null && userRepository.existsByUsername(userDto.getUsername())) {
      throw new UserAlreadyExistsException(userDto.getUsername());
    }
    if (userDto.getId() != null && userRepository.existsByUsernameAndIdIsNot(
        userDto.getUsername(), userDto.getId())) {
      throw new UserAlreadyExistsException(userDto.getUsername());
    }
  }
}
