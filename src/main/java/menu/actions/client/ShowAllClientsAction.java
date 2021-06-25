package menu.actions.client;

import controllers.ClientController;
import menu.actions.Action;
import model.entities.Client;

import java.util.List;

public class ShowAllClientsAction implements Action {
    @Override
    public void doAction(int index) {
        List<Client> clients = ClientController.getInstance().getClients();

        if (clients.size() != 0) {
            for (Client client : clients) {
                System.out.println(client.toString());
                System.out.println();
            }
        } else {
            System.out.println("The client list is empty.");
            System.out.println();
        }
    }
}
