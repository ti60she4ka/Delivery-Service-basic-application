package actions.product;

import actions.Action;
import controllers.ProductController;
import exceptions.EntityCannotBeAddedException;
import java.util.ArrayList;
import java.util.List;
import model.entities.Category;
import model.entities.Product;
import utilities.ConsoleUtility;

public class CreateNewProductAction implements Action {

  @Override
  public void doAction(int index) throws EntityCannotBeAddedException {
    Product product = getNewProduct();

    ProductController.getInstance().create(product);
    System.out.println("\nNew product added successfully!\n");
  }

  private Product getNewProduct() {
    List<Category> categories = new ArrayList<>();
    List<Category> allCategories = new ArrayList<>();

    System.out.print("Enter the product information:\nName — ");
    String name = ConsoleUtility.getScanner().nextLine();

    while (true) {
      System.out.println();
      printCategories(allCategories);

      System.out.print("Select the category which you want to add to the product: ");
      int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

      if (choice == allCategories.size() + 1) {
        break;
      }

      categories.add(allCategories.get(choice - 1));
    }

    return Product.builder().name(name).categories(categories).build();
  }

  private void printCategories(List<Category> categories) {
    for (int i = 0; i < categories.size(); i++) {
      System.out.println((i + 1) + ". " + categories.get(i).getName());
    }
    System.out.println((categories.size() + 1) + ". Finish selection");
  }
}
