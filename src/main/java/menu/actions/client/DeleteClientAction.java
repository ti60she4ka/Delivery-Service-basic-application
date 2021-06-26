package menu.actions.client;

import controllers.ClientController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.Client;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class DeleteClientAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException {
        List<Client> clients = ClientController.getInstance().getAll();

        if (clients.size() == 0) {
            System.out.println("The client list is empty.");
            System.out.println();
            return;
        }

        printListOfClients(clients);

        System.out.print("Enter ID of the client who you want to delete: ");
        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
        ClientController.getInstance().deleteById(id);

        System.out.println("\nClient with the specified ID was successfully deleted.");

        System.out.println();
        Json.serializeClientDataStorage();
    }

    private void printListOfClients(List<Client> clients) {
        for (Client client : clients) {
            System.out.println(client.toString());
            System.out.println();
        }
    }
}
