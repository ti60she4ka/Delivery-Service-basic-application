package menu.actions.product;

import controllers.ProductController;
import menu.actions.Action;
import model.entities.Product;

import java.util.List;

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
