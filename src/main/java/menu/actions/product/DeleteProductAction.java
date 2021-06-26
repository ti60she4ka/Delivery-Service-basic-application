package menu.actions.product;

import controllers.ProductController;
import controllers.ShopController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.Product;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class DeleteProductAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException {
        List<Product> products = ProductController.getInstance().getAll();

        if (products.size() == 0) {
            System.out.println("The product list is empty.");
            System.out.println();
            return;
        }

        printListOfProducts(products);

        System.out.print("Enter ID of the product which you want to delete: ");
        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());

        Product product = ProductController.getInstance().getById(id);
        ShopController.getInstance().deleteProductFromShops(product);

        ProductController.getInstance().deleteById(id);

        System.out.println("\nProduct with the specified ID was successfully deleted.");

        System.out.println();
        Json.serializeProductDataStorage();
        Json.serializeShopDataStorage();
    }

    private void printListOfProducts(List<Product> products) {
        for (Product product : products) {
            System.out.println(product.toString());
            System.out.println();
        }
    }
}
