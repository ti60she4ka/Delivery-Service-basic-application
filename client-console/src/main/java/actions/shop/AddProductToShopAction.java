package actions.shop;

import actions.Action;
import controllers.ProductController;
import controllers.ShopController;
import java.util.List;
import model.entities.Product;
import model.entities.Shop;
import utilities.ConsoleUtility;

public class AddProductToShopAction implements Action {

  @Override
  public void doAction(int index) {
    List<Shop> shops = (List<Shop>) ShopController.getInstance().getAll();

    if (shops.size() == 0) {
      System.out.println("The shop list is empty.\n");
      return;
    }

    printShopNames(shops);

    System.out.print("Enter the shop to which you want to add the product: ");
    int entityIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
    Shop shop = shops.get(entityIndex - 1);

    List<Product> products = (List<Product>) ProductController.getInstance().getAll();

    if (products.size() == 0) {
      System.out.println("The product list is empty.\n");
      return;
    }

    printProductNames(products);

    System.out.print("Enter the product which you want to add to the shop: ");

    entityIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
    Product product = Product.builder().build();

    System.out.print("Quantity — ");
    int quantity = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

    System.out.println("\nThe product was successfully added to the shop.\n");
  }

  private void printShopNames(List<Shop> shops) {
    System.out.println();
    for (int i = 0; i < shops.size(); i++) {
      System.out.println((i + 1) + ". " + shops.get(i).getName());
    }
  }

  private void printProductNames(List<Product> products) {
    System.out.println();
    for (int i = 0; i < products.size(); i++) {
      System.out.println((i + 1) + ". " + products.get(i).getName());
    }
  }
}
