package api.services;

import exceptions.ClientNotFoundException;
import model.entities.Client;

public interface ClientService extends AbstractService<Client> {
    Client get(Client client) throws ClientNotFoundException;
}
