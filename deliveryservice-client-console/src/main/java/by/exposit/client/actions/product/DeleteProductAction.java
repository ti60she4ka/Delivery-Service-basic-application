package by.exposit.client.actions.product;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ProductController;
import by.exposit.core.exceptions.EntityNotFoundException;
import by.exposit.core.model.entities.Product;
import by.exposit.client.utilities.ConsoleUtility;
import java.util.List;

public class DeleteProductAction implements Action {

  private final ProductController productController;

  public DeleteProductAction(ProductController productController) {
    this.productController = productController;
  }

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<Product> products = (List<Product>) productController.getAll();

    if (products.size() == 0) {
      System.out.println("The product list is empty.\n");
      return;
    }

    printListOfProducts(products);

    System.out.print("Enter ID of the product which you want to delete: ");
    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());

    Product product = productController.getById(id);

    productController.deleteById(id);

    System.out.println("\nProduct with the specified ID was successfully deleted.\n");
  }

  private void printListOfProducts(List<Product> products) {
    for (Product product : products) {
      System.out.println(product.toString() + '\n');
    }
  }
}
