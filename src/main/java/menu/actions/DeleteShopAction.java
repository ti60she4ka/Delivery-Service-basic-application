package menu.actions;

import controllers.ShopController;
import exceptions.EntityNotFoundException;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class DeleteShopAction implements Action {
    @Override
    public void doAction(int index) {
        List<Shop> shops = ShopController.getInstance().getShops();

        if (shops.size() == 0) {
            System.out.println("The shop list is empty.");
            System.out.println();
            return;
        }

        printListOfShops(shops);

        System.out.print("Enter ID of the shop which you want to delete: ");
        try {
            long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
            ShopController.getInstance().deleteShop(id);

            System.out.println("\nShop with the specified id was successfully deleted.");
        } catch (NumberFormatException exception) {
            System.out.println("\nInvalid data entered.");
        } catch (EntityNotFoundException exception) {
            System.out.println('\n' + exception.getMessage());
        }

        System.out.println();
        Json.serializeShopDataStorage();
    }

    private void printListOfShops(List<Shop> shops) {
        for (Shop shop : shops) {
            System.out.println(shop.toString());
            System.out.println();
        }
    }
}
