package by.exposit.client.actions.product;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.ProductController;
import by.exposit.core.model.entities.Product;
import java.util.List;

public class ShowAllProductsAction implements Action {

  private final ProductController productController;

  public ShowAllProductsAction(ProductController productController) {
    this.productController = productController;
  }

  @Override
  public void doAction(int index) {
    List<Product> products = (List<Product>) productController.getAll();

    if (products.size() != 0) {
      for (Product product : products) {
        System.out.println(product.toString() + '\n');
      }
    } else {
      System.out.println("The product list is empty.\n");
    }
  }
}
