package by.exposit.client.actions.shop;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ShopController;
import by.exposit.core.model.entities.Shop;
import by.exposit.client.utilities.ConsoleUtility;
import java.util.List;

public class UpdateProductInfoInShopAction implements Action {

  private final ShopController shopController;

  public UpdateProductInfoInShopAction(ShopController shopController) {
    this.shopController = shopController;
  }

  @Override
  public void doAction(int index) throws Exception {
    List<Shop> shops = (List<Shop>) shopController.getAll();

    if (shops.size() == 0) {
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
