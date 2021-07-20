package by.exposit.actions.product;

import by.exposit.actions.Action;
import by.exposit.controllers.ProductController;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.exceptions.ProductCannotBeAddedException;
import by.exposit.model.entities.Category;
import by.exposit.model.entities.Product;
import by.exposit.utilities.ConsoleUtility;
import java.util.ArrayList;
import java.util.List;

public class EditProductAction implements Action {

  private final ProductController productController;

  public EditProductAction(ProductController productController) {
    this.productController = productController;
  }

  @Override
  public void doAction(int index) throws EntityNotFoundException, ProductCannotBeAddedException {
    List<Product> products = (List<Product>) productController.getAll();

    if (products.size() == 0) {
      System.out.println("The product list is empty.\n");
      return;
    }

    printListOfProducts(products);

    System.out.print("Enter ID of the product which you want to edit: ");

    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
    Product product = productController.getById(id);

    editProduct(product);

    System.out.println();
  }

  private void printListOfProducts(List<Product> products) {
    for (Product product : products) {
      System.out.println(product.toString() + '\n');
    }
  }

  private void editProduct(Product product) throws ProductCannotBeAddedException {
    System.out.print("1) Name\n"
        + "2) Categories\n"
        + "Select the field you want to edit: ");

    int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

    System.out.println();
    switch (choice) {
      case 1:
        System.out.print("Enter a new name: ");
        product.setName(getNewName());
        break;
      case 2:
        product.setCategories(getNewCategories());
        break;
      default:
        System.out.println("There is no such item in the menu.");
    }
  }

  private List<Category> getNewCategories() {
    List<Category> categories = new ArrayList<>();
    List<Category> allCategories = new ArrayList<>();
    while (true) {
      System.out.println();
      printCategories(allCategories);

      System.out.print("Select the category which you want to add to the product: ");
      int categoryChoice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

      if (categoryChoice == allCategories.size() + 1) {
        break;
      }

      categories.add(allCategories.get(categoryChoice - 1));
    }

    return categories;
  }

  private void printCategories(List<Category> categories) {
    for (int i = 0; i < categories.size(); i++) {
      System.out.println((i + 1) + ". " + categories.get(i).getName());
    }
    System.out.println((categories.size() + 1) + ". Finish selection");
  }

  private String getNewName() throws ProductCannotBeAddedException {
    String name = ConsoleUtility.getScanner().nextLine();
    if (productController.getAll().stream()
        .anyMatch(product -> product.getName().equalsIgnoreCase(name))) {

      throw new ProductCannotBeAddedException(name);
    }

    return name;
  }
}
