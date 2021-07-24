package by.exposit.core.controllers;

import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.User;
import by.exposit.core.services.user.UserService;
import java.util.Collection;

public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  public void create(User user) throws EntityCannotBeAddedException {
    userService.create(user);
  }

  public Collection<User> getAll() {
    return userService.getAll();
  }

  public void deleteById(Long id) throws EntityNotFoundException {
    userService.deleteById(id);
  }

  public User getById(Long id) throws EntityNotFoundException {
    return userService.getById(id);
  }
}
