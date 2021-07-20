package by.exposit.actions.shop;

import by.exposit.actions.Action;
import by.exposit.controllers.ShopController;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.Shop;
import by.exposit.utilities.ConsoleUtility;
import java.util.List;

public class DeleteShopAction implements Action {

  private final ShopController shopController;

  public DeleteShopAction(ShopController shopController) {
    this.shopController = shopController;
  }

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<Shop> shops = (List<Shop>) shopController.getAll();

    if (shops.size() == 0) {
      System.out.println("The shop list is empty.\n");
      return;
    }

    printListOfShops(shops);

    System.out.print("Enter ID of the shop which you want to delete: ");

    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
    shopController.deleteById(id);

    System.out.println("\nShop with the specified ID was successfully deleted.\n");
  }

  private void printListOfShops(List<Shop> shops) {
    for (Shop shop : shops) {
      System.out.println(shop.toString() + '\n');
    }
  }
}
