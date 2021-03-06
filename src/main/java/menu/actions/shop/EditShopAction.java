package menu.actions.shop;

import controllers.ShopController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.ProductStorage;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class EditShopAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException {
        List<Shop> shops = ShopController.getInstance().getAll();

        if (shops.size() == 0) {
            System.out.println("The shop list is empty.\n");
            return;
        }

        printListOfShops(shops);

        System.out.print("Enter ID of the client which you want to edit: ");

        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
        Shop shop = ShopController.getInstance().getById(id);

        editShop(shop);

        Json.serializeShopDataStorage();
    }

    private void printListOfShops(List<Shop> shops) {
        for (Shop shop : shops) {
            System.out.println(shop.toString() + '\n');
        }
    }

    private void editShop(Shop shop){
        System.out.print("1) Name\n"
                + "2) City\n"
                + "Select the field you want to edit: ");

        int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println();
        switch (choice){
            case 1:
                System.out.print("Enter a new name: ");
                shop.setName(ConsoleUtility.getScanner().nextLine());
                updateProductsInShop(shop);
                break;
            case 2:
                System.out.print("Enter a new city: ");
                shop.setCity(ConsoleUtility.getScanner().nextLine());
                break;
            default:
                System.out.println("There is no such item in the menu.");
        }
        System.out.println();
    }

    private void updateProductsInShop(Shop shop){
        for (ProductStorage item : shop.getProductStorages()){
            item.getProduct().setNameOfShop(shop.getName());
        }
    }
}
