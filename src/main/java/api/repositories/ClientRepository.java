package api.repositories;

import exceptions.ClientNotFoundException;
import model.entities.Client;

public interface ClientRepository extends AbstractRepository<Client>{
    Client get(Client client) throws ClientNotFoundException;
}
