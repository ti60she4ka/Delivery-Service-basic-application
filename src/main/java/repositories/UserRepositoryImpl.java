package repositories;

import api.repositories.UserRepository;
import exceptions.UserCannotBeAddedException;
import exceptions.UserNotFoundException;
import exceptions.EntityCannotBeAddedException;
import model.entities.User;
import storages.UserDataStorage;

public class UserRepositoryImpl extends AbstractRepositoryImpl<User> implements UserRepository {
    private static UserRepositoryImpl instance;
    private final UserDataStorage userDataStorage;

    private UserRepositoryImpl(){
        super(UserDataStorage.getInstance());
        userDataStorage = (UserDataStorage) abstractDataStorage;
        entityType = "User";
    }

    public static UserRepositoryImpl getInstance(){
        if(instance == null){
            instance = new UserRepositoryImpl();
        }

        return instance;
    }

    @Override
    public User get(User user) throws UserNotFoundException {
        return userDataStorage.getEntities().stream()
                .filter(item -> item.getFirstName().equalsIgnoreCase(user.getFirstName())
                && item.getLastName().equalsIgnoreCase(user.getLastName())
                && item.getEmail().equalsIgnoreCase(user.getEmail()))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void create(User entity) throws EntityCannotBeAddedException {
        if(userDataStorage.getEntities().stream()
                .anyMatch(item -> item.getEmail().equalsIgnoreCase(entity.getEmail()))){

            throw new UserCannotBeAddedException(entity.getEmail());
        }

        super.create(entity);
    }
}