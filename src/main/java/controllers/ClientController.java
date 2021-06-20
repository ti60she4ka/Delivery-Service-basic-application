package controllers;

import api.services.ClientService;
import exceptions.EntityNotFoundException;
import model.entities.Client;
import services.ClientServiceImpl;

import java.util.List;

public class ClientController {
    private static ClientController instance;
    private ClientService clientService;

    private ClientController(){
        clientService = ClientServiceImpl.getInstance();
    }

    public static ClientController getInstance() {
        if(instance == null){
            instance = new ClientController();
        }

        return instance;
    }

    public void createClient(Client client){
        clientService.create(client);
    }

    public List<Client> getClients(){
        return clientService.getAll();
    }

    public void deleteClient(long id) throws EntityNotFoundException {
        clientService.delete(id);
    }

    public Client getClient(long id) throws EntityNotFoundException {
        return clientService.get(id);
    }
}
