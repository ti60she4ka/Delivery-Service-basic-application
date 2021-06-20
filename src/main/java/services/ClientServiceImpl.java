package services;

import api.repositories.ClientRepository;
import api.services.ClientService;
import model.entities.Client;
import repositories.ClientRepositoryImpl;

public class ClientServiceImpl extends AbstractServiceImpl<Client> implements ClientService {
    private static ClientServiceImpl instance;
    private ClientRepository clientRepository;

    private ClientServiceImpl(){
        super(ClientRepositoryImpl.getInstance());
        clientRepository = (ClientRepository) abstractRepository;
    }

    public static ClientServiceImpl getInstance(){
        if(instance == null){
            instance = new ClientServiceImpl();
        }

        return instance;
    }
}
