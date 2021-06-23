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

        MenuItem shopService = new MenuItem("Shop service",
                initializeShopServiceMenu(MenuContext.getMenu()), new GoToSubmenuAction());
        MenuContext.getMenu().getMenuItems().add(shopService);

        MenuItem exitProgram = new MenuItem("Exit.",
                null, new ExitProgramAction());
        MenuContext.getMenu().getMenuItems().add(exitProgram);
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

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        clientServiceMenu.getMenuItems().add(backToPreviousMenu);

        return clientServiceMenu;
    }

    private static Menu initializeShopServiceMenu(Menu previousMenu){
        Menu shopServiceMenu = new Menu();
        shopServiceMenu.setMenuItems(new ArrayList<>());
        shopServiceMenu.setPreviousMenu(previousMenu);

        MenuItem addNewShop = new MenuItem("Add a new shop.",
                null, new AddNewShopAction());
        shopServiceMenu.getMenuItems().add(addNewShop);

        MenuItem showAllShops = new MenuItem("Show all shops.",
                null, new ShowAllShopsAction());
        shopServiceMenu.getMenuItems().add(showAllShops);

        MenuItem deleteShop = new MenuItem("Delete shop.",
                null, new DeleteShopAction());
        shopServiceMenu.getMenuItems().add(deleteShop);

        MenuItem editShop = new MenuItem("Edit shop.",
                null, new EditShopAction());
        shopServiceMenu.getMenuItems().add(editShop);

        MenuItem backToPreviousMenu = new MenuItem("Back.",
                null, new GoToPreviousMenuAction());
        shopServiceMenu.getMenuItems().add(backToPreviousMenu);

        return shopServiceMenu;
    }
}