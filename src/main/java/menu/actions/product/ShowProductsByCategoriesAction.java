package menu.actions.product;

import controllers.ShopController;
import menu.actions.Action;
import model.entities.ProductStorage;
import model.enums.Category;
import utilities.ConsoleUtility;

import java.util.EnumSet;
import java.util.List;

public class ShowProductsByCategoriesAction implements Action {
    @Override
    public void doAction(int index) {
        Category[] allCategories = Category.values();
        EnumSet<Category> categories = EnumSet.noneOf(Category.class);

        while (true){
            printCategories(allCategories);
            System.out.println((allCategories.length + 1) + ". Finish the selection");
            System.out.print("Select a category: ");
            int categoryIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            if(categoryIndex == allCategories.length + 1){
                break;
            }

            categories.add(allCategories[categoryIndex - 1]);
            System.out.println();
        }

        List<ProductStorage> productStorages = ShopController.getInstance()
                .getAllProductStoragesByCategoriesContains(categories);

        printProductStorages(productStorages);
    }

    private void printCategories(Category[] categories) {
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i].getName());
        }
    }

    private void printProductStorages(List<ProductStorage> productStorages){
        System.out.println();
        for (ProductStorage productStorage : productStorages) {
            System.out.println(productStorage + " in " + productStorage.getProduct().getNameOfShop());
        }
        System.out.println();
    }
}
