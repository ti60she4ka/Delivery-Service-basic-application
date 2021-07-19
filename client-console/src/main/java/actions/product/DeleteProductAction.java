package actions.product;

import actions.Action;
import controllers.ProductController;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.entities.Product;
import utilities.ConsoleUtility;

public class DeleteProductAction implements Action {

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<Product> products = (List<Product>) ProductController.getInstance().getAll();

    if (products.size() == 0) {
      System.out.println("The product list is empty.\n");
      return;
    }

    printListOfProducts(products);

    System.out.print("Enter ID of the product which you want to delete: ");
    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());

    Product product = ProductController.getInstance().getById(id);

    ProductController.getInstance().deleteById(id);

    System.out.println("\nProduct with the specified ID was successfully deleted.\n");
  }

  private void printListOfProducts(List<Product> products) {
    for (Product product : products) {
      System.out.println(product.toString() + '\n');
    }
  }
}
