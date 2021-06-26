package controllers;

import api.services.ClientService;
import exceptions.ClientNotFoundException;
import exceptions.EntityCannotBeAddedException;
import exceptions.EntityNotFoundException;
import model.entities.Client;
import services.ClientServiceImpl;

import java.util.List;

public class ClientController {
    private static ClientController instance;
    private final ClientService clientService;

    private ClientController(){
        clientService = ClientServiceImpl.getInstance();
    }

    public static ClientController getInstance() {
        if(instance == null){
            instance = new ClientController();
        }

        return instance;
    }

    public void create(Client client) throws EntityCannotBeAddedException {
        clientService.create(client);
    }

    public List<Client> getAll(){
        return clientService.getAll();
    }

    public void deleteById(long id) throws EntityNotFoundException {
        clientService.deleteById(id);
    }

    public Client getById(long id) throws EntityNotFoundException {
        return clientService.getById(id);
    }

    public Client get(Client client) throws ClientNotFoundException {
        return clientService.get(client);
    }
}
