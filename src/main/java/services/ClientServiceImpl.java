package services;

import api.repositories.ClientRepository;
import api.services.ClientService;
import exceptions.ClientNotFoundException;
import model.entities.Client;
import repositories.ClientRepositoryImpl;

public class ClientServiceImpl extends AbstractServiceImpl<Client> implements ClientService {
    private static ClientServiceImpl instance;
    private final ClientRepository clientRepository;

    private ClientServiceImpl() {
        super(ClientRepositoryImpl.getInstance());
        clientRepository = (ClientRepository) abstractRepository;
    }

    public static ClientServiceImpl getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }

        return instance;
    }

    @Override
    public Client get(Client client) throws ClientNotFoundException {
        return clientRepository.get(client);
    }
}
