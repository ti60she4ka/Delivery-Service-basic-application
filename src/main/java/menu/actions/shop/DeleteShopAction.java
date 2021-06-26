package menu.actions.shop;

import controllers.ShopController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class DeleteShopAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException {
        List<Shop> shops = ShopController.getInstance().getAll();

        if (shops.size() == 0) {
            System.out.println("The shop list is empty.");
            System.out.println();
            return;
        }

        printListOfShops(shops);

        System.out.print("Enter ID of the shop which you want to delete: ");

        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
        ShopController.getInstance().deleteById(id);

        System.out.println("\nShop with the specified ID was successfully deleted.");

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
