package menu.actions.client;

import controllers.ClientController;
import exceptions.EntityCannotBeAddedException;
import menu.actions.Action;
import model.entities.Client;
import utilities.ConsoleUtility;
import utilities.Json;

public class CreateNewClientAction implements Action {
    @Override
    public void doAction(int index) throws EntityCannotBeAddedException {
        Client client = getNewClient();

        ClientController.getInstance().create(client);
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
