package controllers;

import api.services.UserService;
import exceptions.UserNotFoundException;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.User;
import services.UserServiceImpl;

import java.util.List;

public class UserController {
    private static UserController instance;
    private final UserService userService;

    private UserController(){
        userService = UserServiceImpl.getInstance();
    }

    public static UserController getInstance() {
        if(instance == null){
            instance = new UserController();
        }

        return instance;
    }

    public void create(User user) throws EntityCannotBeAddedException {
        userService.create(user);
    }

    public List<User> getAll(){
        return userService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        userService.deleteById(id);
    }

    public User getById(long id) throws EntityNotFoundException {
        return userService.getById(id);
    }

    public User get(User user) throws UserNotFoundException {
        return userService.get(user);
    }
}
