package services;

import api.repositories.UserRepository;
import api.services.UserService;
import exceptions.UserNotFoundException;
import model.entities.User;

public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
    private static UserServiceImpl instance;
    private UserRepository userRepository;

    private UserServiceImpl(){
    }

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }

        return instance;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        abstractRepository = userRepository;
    }

    @Override
    public User get(User user) throws UserNotFoundException {
        return userRepository.get(user);
    }
}
