package initializers;

import menu.Menu;
import menu.MenuContext;
import menu.MenuItem;
import menu.actions.*;

import java.util.ArrayList;

public class MenuInitializer implements Initializer{
    public void init(){
        initializeRootMenu();
    }

    private static void initializeRootMenu(){
        MenuContext.getMenu().setMenuItems(new ArrayList<>());

        MenuItem clientService = new MenuItem("Client service.",
                initializeClientServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(clientService);
    }

    private static Menu initializeClientServiceMenu(Menu previousMenu){
        Menu clientServiceMenu = new Menu();
        clientServiceMenu.setMenuItems(new ArrayList<>());
        clientServiceMenu.setPreviousMenu(previousMenu);

        MenuItem addNewClient = new MenuItem("Add a new client.",
                null, new AddNewClientAction());
        clientServiceMenu.getMenuItems().add(addNewClient);

        MenuItem showAllClients = new MenuItem("Show all clients.",
                null, new ShowAllClientsAction());
        clientServiceMenu.getMenuItems().add(showAllClients);

        MenuItem deleteClient = new MenuItem("Delete client.",
                null, new DeleteClientAction());
        clientServiceMenu.getMenuItems().add(deleteClient);

        MenuItem editClient = new MenuItem("Edit client.",
                null, new EditClientAction());
        clientServiceMenu.getMenuItems().add(editClient);

        return clientServiceMenu;
    }
}