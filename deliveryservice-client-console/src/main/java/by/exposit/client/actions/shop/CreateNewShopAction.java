package by.exposit.client.actions.shop;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ShopController;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.model.entities.Shop;
import by.exposit.client.utilities.ConsoleUtility;

public class CreateNewShopAction implements Action {

  private final ShopController shopController;

  public CreateNewShopAction(ShopController shopController) {
    this.shopController = shopController;
  }

  @Override
  public void doAction(int index) throws EntityCannotBeAddedException {
    Shop shop = getNewShop();

    shopController.create(shop);
    System.out.println("\nNew shop added successfully!\n");
  }

  private Shop getNewShop() {
    String name;
    String city;
    System.out.println("Enter the shop information:");

    System.out.print("Name — ");
    name = ConsoleUtility.getScanner().nextLine();

    System.out.print("City — ");
    city = ConsoleUtility.getScanner().nextLine();

    return Shop.builder().name(name).city(city).build();
  }
}
