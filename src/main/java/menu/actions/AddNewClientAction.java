package menu.actions;

import controllers.ClientController;
import model.entities.Client;
import storages.ClientDataStorage;
import utilities.ConsoleUtility;
import utilities.Json;

public class AddNewClientAction implements Action {
    @Override
    public void doAction(int index) {
        Client client = getNewClient();

        ClientController.getInstance().createClient(client);
        System.out.println("\nNew client added successfully!\n");

        Json.serializeClientDataStorage();
    }

    private Client getNewClient() {
        String firstName;
        String secondName;
        String email;
        System.out.println("Enter the client information:");

        System.out.print("First name — ");
        firstName = ConsoleUtility.getScanner().nextLine();

        System.out.print("Last name — ");
        secondName = ConsoleUtility.getScanner().nextLine();

        System.out.print("Email — ");
        email = ConsoleUtility.getScanner().nextLine();

        return new Client(firstName, secondName, email);
    }
}
