package menu.actions.product;

import controllers.ArticleController;
import controllers.ShopController;
import menu.actions.Action;
import model.entities.Article;
import model.entities.Product;
import model.entities.Shop;
import utilities.ConsoleUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShowProductsByAttributesAction implements Action {
    @Override
    public void doAction(int index) throws Exception {
        List<Article> productStorages = ArticleController.getInstance().getAll();
        boolean finish = false;

        while (!finish) {
            System.out.println("1) Shop\n"
                    + "2) Price\n"
                    + "3) Quantity\n"
                    + "4) Perform a search");

            System.out.print("Select the search attribute: ");
            int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            switch (choice) {
                case 1: {
                    filterByShops(productStorages);
                    break;
                }
                case 2: {
                    filterByPrice(productStorages);
                    break;
                }
                case 3: {
                    filterByQuantity(productStorages);
                    break;
                }
                case 4: {
                    finish = true;
                    printProductStorages(productStorages);
                    break;
                }
                default: {
                    System.out.println("There is no such item in the menu.");
                }
            }
            System.out.println();
        }
    }

    private void printShops(List<Shop> shops) {
        System.out.println();
        for (int i = 0; i < shops.size(); i++) {
            System.out.println((i + 1) + ". " + shops.get(i).getName() + " in " + shops.get(i).getCity());
        }
    }

    private boolean isProductPresentInOneOfShops(Product product, List<Shop> shops){
        for (Shop shop : shops){
            if(shop.getName().equals(product.getName())){
                return true;
            }
        }

        return false;
    }

    private void printProductStorages(List<Article> productStorages){
        System.out.println();
        for (Article productStorage : productStorages) {
            System.out.println(productStorage + " in " + productStorage.getProduct().getName());
        }
    }

    private void filterByShops(List<Article> productStorages){
        List<Shop> allShops = ShopController.getInstance().getAll();
        List<Shop> shopsForSearch = new ArrayList<>();
        while (true) {
            printShops(allShops);
            System.out.println((allShops.size() + 1) + ". Finish the selection");

            System.out.print("Select a shop: ");
            int shopIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            if(shopIndex == allShops.size() + 1){
                break;
            }

            shopsForSearch.add(allShops.get(shopIndex - 1));
        }
        List<Shop> finalShopsForSearch = shopsForSearch.stream().distinct()
                .collect(Collectors.toList());

        productStorages.removeIf(item -> !isProductPresentInOneOfShops(item.getProduct(), finalShopsForSearch));
    }

    private void filterByPrice(List<Article> productStorages){
        double priceFrom;
        double priceTo;

        System.out.print("Price from — ");
        priceFrom = Double.parseDouble(ConsoleUtility.getScanner().nextLine());

        System.out.print("Price to — ");
        priceTo = Double.parseDouble(ConsoleUtility.getScanner().nextLine());

        productStorages.removeIf(item -> item.getPrice() < priceFrom
                || item.getPrice() > priceTo);
    }

    private void filterByQuantity(List<Article> productStorages){
        int quantityFrom;
        int quantityTo;

        System.out.print("Quantity from ");
        quantityFrom = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.print("Quantity to ");
        quantityTo = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        productStorages.removeIf(item -> item.getAmount() < quantityFrom
                || item.getAmount() > quantityTo);
    }
}
