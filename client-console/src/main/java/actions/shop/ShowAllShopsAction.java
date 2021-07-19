package actions.shop;

import actions.Action;
import controllers.ShopController;
import java.util.List;
import model.entities.Shop;

public class ShowAllShopsAction implements Action {

  @Override
  public void doAction(int index) {
    List<Shop> shops = (List<Shop>) ShopController.getInstance().getAll();

    if (shops.size() != 0) {
      for (Shop shop : shops) {
        System.out.println(shop.toString() + '\n');
      }
    } else {
      System.out.println("The shop list is empty.\n");
    }
  }
}
