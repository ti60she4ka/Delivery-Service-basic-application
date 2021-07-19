package actions.shop;

import actions.Action;
import controllers.ShopController;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.entities.Shop;
import utilities.ConsoleUtility;

public class DeleteShopAction implements Action {

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<Shop> shops = (List<Shop>) ShopController.getInstance().getAll();

    if (shops.size() == 0) {
      System.out.println("The shop list is empty.\n");
      return;
    }

    printListOfShops(shops);

    System.out.print("Enter ID of the shop which you want to delete: ");

    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
    ShopController.getInstance().deleteById(id);

    System.out.println("\nShop with the specified ID was successfully deleted.\n");
  }

  private void printListOfShops(List<Shop> shops) {
    for (Shop shop : shops) {
      System.out.println(shop.toString() + '\n');
    }
  }
}
