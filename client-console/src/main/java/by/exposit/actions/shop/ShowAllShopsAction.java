package by.exposit.actions.shop;

import by.exposit.actions.Action;
import by.exposit.controllers.ShopController;
import by.exposit.model.entities.Shop;
import java.util.List;

public class ShowAllShopsAction implements Action {

  private final ShopController shopController;

  public ShowAllShopsAction(ShopController shopController) {
    this.shopController = shopController;
  }

  @Override
  public void doAction(int index) {
    List<Shop> shops = (List<Shop>) shopController.getAll();

    if (shops.size() != 0) {
      for (Shop shop : shops) {
        System.out.println(shop.toString() + '\n');
      }
    } else {
      System.out.println("The shop list is empty.\n");
    }
  }
}
