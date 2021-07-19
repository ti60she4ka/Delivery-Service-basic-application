package actions.product;

import actions.Action;
import controllers.ProductController;
import java.util.List;
import model.entities.Product;

public class ShowAllProductsAction implements Action {

  @Override
  public void doAction(int index) {
    List<Product> products = (List<Product>) ProductController.getInstance().getAll();

    if (products.size() != 0) {
      for (Product product : products) {
        System.out.println(product.toString() + '\n');
      }
    } else {
      System.out.println("The product list is empty.\n");
    }
  }
}
