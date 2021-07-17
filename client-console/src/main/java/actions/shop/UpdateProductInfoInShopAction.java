package actions.shop;

import controllers.ShopController;
import actions.Action;
import model.entities.Shop;
import utilities.ConsoleUtility;

import java.util.List;

public class UpdateProductInfoInShopAction implements Action {
    @Override
    public void doAction(int index) throws Exception {
        List<Shop> shops = (List<Shop>) ShopController.getInstance().getAll();

        if(shops.size() == 0){
            System.out.println("The shop list is empty.\n");
            return;
        }

        System.out.print("Enter the shop: ");
        int entityIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.print("Enter the product which you want to edit: ");
        entityIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println("\nThe product information was successfully changed.\n");
    }
}
