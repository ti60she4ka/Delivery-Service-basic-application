package by.exposit.actions.shop;

import by.exposit.actions.Action;
import by.exposit.controllers.ShopController;
import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.model.entities.Shop;
import by.exposit.utilities.ConsoleUtility;

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
