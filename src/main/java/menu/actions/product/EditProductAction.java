package menu.actions.product;

import controllers.ProductController;
import controllers.ShopController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.Product;
import model.enums.Category;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.EnumSet;
import java.util.List;

public class EditProductAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException {
        List<Product> products = ProductController.getInstance().getProducts();

        if (products.size() == 0) {
            System.out.println("The product list is empty.");
            System.out.println();
            return;
        }

        printListOfProducts(products);

        System.out.print("Enter ID of the product which you want to edit: ");

        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
        Product product = ProductController.getInstance().getProduct(id);

        editProduct(product);

        ShopController.getInstance().updateProductInShops(product);

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

    private void editProduct(Product product){
        System.out.print("1) Name\n"
                + "2) Categories\n"
                + "Select the field you want to edit: ");

        int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println();
        switch (choice){
            case 1:
                System.out.print("Enter a new name: ");
                product.setName(ConsoleUtility.getScanner().nextLine());
                break;
            case 2:
                product.setCategories(getNewCategories());
                break;
            default:
                System.out.println("There is no such item in the menu.");
        }
    }

    private EnumSet<Category> getNewCategories(){
        EnumSet<Category> categories = EnumSet.noneOf(Category.class);
        Category[] allTheCategories = Category.values();
        while (true) {
            System.out.println();
            printCategories(allTheCategories);

            System.out.print("Select the category which you want to add to the product: ");
            int categoryChoice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            if(categoryChoice == allTheCategories.length + 1){
                break;
            }

            categories.add(allTheCategories[categoryChoice - 1]);
        }

        return categories;
    }

    private void printCategories(Category[] categories) {
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i].getName());
        }
        System.out.println((categories.length + 1) + ". Finish selection");
    }
}
