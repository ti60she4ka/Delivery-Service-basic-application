package repositories;

import api.repositories.ClientRepository;
import exceptions.ClientCannotBeAddedException;
import exceptions.ClientNotFoundException;
import exceptions.EntityCannotBeAddedException;
import model.entities.Client;
import storages.ClientDataStorage;

public class ClientRepositoryImpl extends AbstractRepositoryImpl<Client> implements ClientRepository {
    private static ClientRepositoryImpl instance;
    private final ClientDataStorage clientDataStorage;

    private ClientRepositoryImpl(){
        super(ClientDataStorage.getInstance());
        clientDataStorage = (ClientDataStorage) abstractDataStorage;
        entityType = "Client";
    }

    public static ClientRepositoryImpl getInstance(){
        if(instance == null){
            instance = new ClientRepositoryImpl();
        }

        return instance;
    }

    @Override
    public Client get(Client client) throws ClientNotFoundException {
        return clientDataStorage.getEntities().stream()
                .filter(item -> item.getFirstName().equalsIgnoreCase(client.getFirstName())
                && item.getLastName().equalsIgnoreCase(client.getLastName())
                && item.getEmail().equalsIgnoreCase(client.getEmail()))
                .findFirst()
                .orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void create(Client entity) throws EntityCannotBeAddedException {
        if(clientDataStorage.getEntities().stream()
                .anyMatch(item -> item.getEmail().equalsIgnoreCase(entity.getEmail()))){

            throw new ClientCannotBeAddedException(entity.getEmail());
        }

        super.create(entity);
    }
}
