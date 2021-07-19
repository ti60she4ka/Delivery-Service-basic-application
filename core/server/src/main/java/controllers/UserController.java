package controllers;

import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import java.util.Collection;
import lombok.Setter;
import model.entities.User;
import services.user.UserService;

public class UserController {

  private static UserController instance;
  @Setter
  private UserService userService;

  private UserController() {
  }

  public static UserController getInstance() {
    if (instance == null) {
      instance = new UserController();
    }

    return instance;
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
