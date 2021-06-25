package menu.actions.shop;

import controllers.ShopController;
import menu.actions.Action;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

public class AddNewShopAction implements Action {
    @Override
    public void doAction(int index) {
        Shop shop = getNewShop();

        ShopController.getInstance().createShop(shop);
        System.out.println("\nNew shop added successfully!\n");

        Json.serializeShopDataStorage();
    }

    private Shop getNewShop() {
        String name;
        String city;
        System.out.println("Enter the shop information:");

        System.out.print("Name — ");
        name = ConsoleUtility.getScanner().nextLine();

        System.out.print("City — ");
        city = ConsoleUtility.getScanner().nextLine();

        return new Shop(name, city);
    }
}
