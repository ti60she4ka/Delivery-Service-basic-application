package menu.actions.product;

import controllers.ProductController;
import exceptions.EntityCannotBeAddedException;
import menu.actions.Action;
import model.entities.Product;
import model.enums.Category;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.EnumSet;

public class CreateNewProductAction implements Action {
    @Override
    public void doAction(int index) throws EntityCannotBeAddedException {
        Product product = getNewProduct();

        ProductController.getInstance().create(product);
        System.out.println("\nNew product added successfully!\n");

        Json.serializeProductDataStorage();
    }

    private Product getNewProduct() {
        String name;
        EnumSet<Category> categories = EnumSet.noneOf(Category.class);
        Category[] allTheCategories = Category.values();
        System.out.println("Enter the product information:");

        System.out.print("Name — ");
        name = ConsoleUtility.getScanner().nextLine();

        while (true) {
            System.out.println();
            printCategories(allTheCategories);

            System.out.print("Select the category which you want to add to the product: ");
            int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            if(choice == allTheCategories.length + 1){
                break;
            }

            categories.add(allTheCategories[choice - 1]);
        }

        return new Product(name, categories);
    }

    private void printCategories(Category[] categories) {
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i].getName());
        }
        System.out.println((categories.length + 1) + ". Finish selection");
    }
}
