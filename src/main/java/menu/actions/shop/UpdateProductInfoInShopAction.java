package menu.actions.shop;

import controllers.ShopController;
import menu.actions.Action;
import model.entities.ProductStorage;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class UpdateProductInfoInShopAction implements Action {
    @Override
    public void doAction(int index) throws Exception {
        List<Shop> shops = ShopController.getInstance().getAll();

        if(shops.size() == 0){
            System.out.println("The shop list is empty.");
            System.out.println();
            return;
        }

        printShopNames(shops);

        Shop shop;
        System.out.print("Enter the shop: ");
        int shopIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        shop = shops.get(shopIndex - 1);

        List<ProductStorage> productStorages = shop.getProductStorages();

        if(productStorages.size() == 0){
            System.out.println("\nThere are no products in the shop.");
            System.out.println();
            return;
        }

        printProductStorages(productStorages);

        System.out.print("Enter the product which you want to edit: ");

        int productStorageIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        ProductStorage productStorage = productStorages.get(productStorageIndex - 1);

        editProductStorage(productStorage);

        System.out.println("\nThe product information was successfully changed.");

        System.out.println();
        Json.serializeShopDataStorage();
    }

    private void printShopNames(List<Shop> shops) {
        for (int i = 0; i < shops.size(); i++) {
            System.out.println((i + 1) + ". " + shops.get(i).getName());
        }
    }

    private void printProductStorages(List<ProductStorage> productStorages){
        System.out.println();
        for (int i = 0; i < productStorages.size(); i++) {
            System.out.println((i + 1) + ". " + productStorages.get(i).toString());
        }
    }

    private void editProductStorage(ProductStorage productStorage){
        System.out.print("\n1) Quantity\n"
                + "2) Price\n"
                + "Select the field you want to edit: ");

        int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println();
        switch (choice){
            case 1:
                System.out.print("Enter a new6 quantity: ");
                int quantity = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
                productStorage.setQuantity(quantity);
                break;
            case 2:
                System.out.print("Enter a new price: ");
                int price = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
                productStorage.getProduct().setPrice(price);
                break;
            default:
                System.out.println("There is no such item in the menu.");
        }
    }
}
