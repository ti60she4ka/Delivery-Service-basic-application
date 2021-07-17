package services.user;

import repositories.user.UserRepository;
import services.AbstractServiceImpl;
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
