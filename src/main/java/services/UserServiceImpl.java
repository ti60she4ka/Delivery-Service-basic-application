package services;

import api.repositories.UserRepository;
import api.services.UserService;
import exceptions.UserNotFoundException;
import model.entities.User;
import repositories.UserRepositoryImpl;

public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {
    private static UserServiceImpl instance;
    private final UserRepository userRepository;

    private UserServiceImpl() {
        super(UserRepositoryImpl.getInstance());
        userRepository = (UserRepository) abstractRepository;
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }

        return instance;
    }

    @Override
    public User get(User user) throws UserNotFoundException {
        return userRepository.get(user);
    }
}
