package menu.actions;

import controllers.ClientController;
import exceptions.EntityNotFoundException;
import model.entities.Client;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class EditClientAction implements Action{
    @Override
    public void doAction(int index) {
        List<Client> clients = ClientController.getInstance().getClients();

        if (clients.size() == 0) {
            System.out.println("The client list is empty.");
            System.out.println();
            return;
        }

        printListOfClients(clients);

        System.out.print("Enter ID of the client who you want to edit: ");
        try {
            long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
            Client client = ClientController.getInstance().getClient(id);

            editClient(client);

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

    private void editClient(Client client){
        System.out.print("1) First name\n"
                + "2) Last name\n"
                + "3) Email\n"
                + "Select the field you want to edit: ");

        int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println();
        switch (choice){
            case 1:
                System.out.print("Enter a new first name: ");
                client.setFirstName(ConsoleUtility.getScanner().nextLine());
                break;
            case 2:
                System.out.print("Enter a new last name: ");
                client.setLastName(ConsoleUtility.getScanner().nextLine());
                break;
            case 3:
                System.out.print("Enter a new email: ");
                client.setEmail(ConsoleUtility.getScanner().nextLine());
                break;
            default:
                System.out.println("There is no such item in the menu");
        }
    }
}
