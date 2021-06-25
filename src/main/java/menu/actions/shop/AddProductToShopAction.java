package menu.actions.shop;

import controllers.ProductController;
import controllers.ShopController;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.Product;
import model.entities.ProductStorage;
import model.entities.Shop;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.List;

public class AddProductToShopAction implements Action {
    @Override
    public void doAction(int index) {
        List<Shop> shops = ShopController.getInstance().getShops();

        if(shops.size() == 0){
            System.out.println("The shop list is empty.");
            System.out.println();
            return;
        }

        printShopNames(shops);

        Shop shop;
        System.out.print("Enter the shop to which you want to add the product: ");
        int shopIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        shop = shops.get(shopIndex - 1);

        List<Product> products = ProductController.getInstance().getProducts();

        if(products.size() == 0){
            System.out.println("The product list is empty.");
            System.out.println();
            return;
        }

        printProductNames(products);

        System.out.print("Enter the product which you want to add to the shop: ");

        int productIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        Product product = new Product(products.get(productIndex - 1));

        System.out.print("\nPrice — ");
        double price = Double.parseDouble(ConsoleUtility.getScanner().nextLine());
        product.setPrice(price);

        System.out.print("Quantity — ");
        int quantity = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        product.setNameOfShop(shop.getName());

        shop.getProductStorages().add(new ProductStorage(product, quantity));
        System.out.println("\nThe product was successfully added to the shop.");

        System.out.println();
        Json.serializeShopDataStorage();
    }

    private void printShopNames(List<Shop> shops) {
        System.out.println();
        for (int i = 0; i < shops.size(); i++) {
            System.out.println((i + 1) + ". " + shops.get(i).getName());
        }
    }

    private void printProductNames(List<Product> products){
        System.out.println();
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName());
        }
    }
}
