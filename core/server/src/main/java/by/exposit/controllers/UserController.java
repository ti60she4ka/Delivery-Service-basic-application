package by.exposit.controllers;

import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.services.user.UserService;
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

  public void deleteById(long id) throws EntityNotFoundException {
    userService.deleteById(id);
  }

  public User getById(long id) throws EntityNotFoundException {
    return userService.getById(id);
  }
}
