package storages;

import model.entities.Client;
import utilities.Json;

public class ClientDataStorage extends AbstractDataStorage<Client> {
    private static ClientDataStorage instance;

    private ClientDataStorage(){}

    public static ClientDataStorage getInstance(){
        if(instance == null){
            instance = new ClientDataStorage();
        }

        return instance;
    }

    public static void setInstance(ClientDataStorage instance) {
        ClientDataStorage.instance = instance;
    }
}
