package menu.actions;

import controllers.ClientController;
import exceptions.EntityNotFoundException;
import model.entities.Client;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class DeleteClientAction implements Action {
    @Override
    public void doAction(int index) {
        List<Client> clients = ClientController.getInstance().getClients();

        if (clients.size() == 0) {
            System.out.println("The client list is empty.");
            System.out.println();
            return;
        }

        printListOfClients(clients);

        System.out.print("Enter ID of the client who you want to delete: ");
        try {
            long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
            ClientController.getInstance().deleteClient(id);

            System.out.println("\nClient with the specified id was successfully deleted.");
        } catch (NumberFormatException exception) {
            System.out.println("\nInvalid data entered.");
        } catch (EntityNotFoundException exception) {
            System.out.println('\n' + exception.getMessage());
        }

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
