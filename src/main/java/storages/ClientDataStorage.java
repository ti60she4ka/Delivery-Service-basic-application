package storages;

import lombok.Setter;
import model.entities.Client;

public class ClientDataStorage extends AbstractDataStorage<Client> {
    @Setter
    private static ClientDataStorage instance;

    private ClientDataStorage(){}

    public static ClientDataStorage getInstance(){
        if(instance == null){
            instance = new ClientDataStorage();
        }

        return instance;
    }
}
