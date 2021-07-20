package by.exposit.actions.product;

import by.exposit.actions.Action;
import by.exposit.controllers.ProductController;
import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.model.entities.Category;
import by.exposit.model.entities.Product;
import by.exposit.utilities.ConsoleUtility;
import java.util.ArrayList;
import java.util.List;

public class CreateNewProductAction implements Action {

  private final ProductController productController;

  public CreateNewProductAction(ProductController productController) {
    this.productController = productController;
  }

  @Override
  public void doAction(int index) throws EntityCannotBeAddedException {
    Product product = getNewProduct();

    productController.create(product);
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
