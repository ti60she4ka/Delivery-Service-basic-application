package repositories;

import api.repositories.ClientRepository;
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
}
