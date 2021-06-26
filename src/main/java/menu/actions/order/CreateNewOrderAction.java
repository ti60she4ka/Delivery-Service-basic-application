package menu.actions.order;

import controllers.ClientController;
import controllers.OrderController;
import controllers.ShopController;
import exceptions.ClientNotFoundException;
import exceptions.NotEnoughProductException;
import menu.actions.Action;
import model.entities.*;
import utilities.ConsoleUtility;
import utilities.Json;

import java.util.ArrayList;
import java.util.List;

public class CreateNewOrderAction implements Action {
    private List<Shop> shops;

    @Override
    public void doAction(int index) throws Exception {
        shops = cloneShops(ShopController.getInstance().getAll());

        List<ProductStorage> orderedProductStorages = getOrderedProductStorages();
        double price = getPrice(orderedProductStorages);
        Client client = getClient();
        String address;

        System.out.print("\nEnter the delivery address: ");
        address = ConsoleUtility.getScanner().nextLine();

        OrderController.getInstance().create(new Order(client, address, orderedProductStorages, price));

        System.out.println("\nThe order was successfully added.\n");
        ShopController.getInstance().setAll(shops);

        Json.serializeOrderDataStorage();
        Json.serializeShopDataStorage();
    }

    private List<ProductStorage> getOrderedProductStorages() throws NotEnoughProductException {
        List<ProductStorage> productStorages = new ArrayList<>();

        if (shops.size() == 0) {
            return productStorages;
        }

        while (true) {
            printShops(shops);
            System.out.println((shops.size() + 1) + ". Make an order.");
            System.out.print("Select a shop: ");

            int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
            if (choice == shops.size() + 1) {
                return productStorages;
            }

            productStorages.add(getOrderedProductStorageFromShop(shops.get(choice - 1)));
            System.out.println();
        }
    }

    private void printShops(List<Shop> shops) {
        for (int i = 0; i < shops.size(); i++) {
            System.out.println((i + 1) + ". " + shops.get(i).getName() + " (" + shops.get(i).getCity() + ')');
        }
    }

    private void printProductStoragesFromShop(Shop shop) {
        for (int i = 0; i < shop.getProductStorages().size(); i++) {
            System.out.println((i + 1) + ". " + shop.getProductStorages().get(i).toString());
        }
    }

    private ProductStorage getOrderedProductStorageFromShop(Shop shop) throws NotEnoughProductException {
        ProductStorage productStorage = new ProductStorage();

        System.out.println();
        printProductStoragesFromShop(shop);

        System.out.print("Select a product: ");
        int productIndex = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        Product productInShop = shop.getProductStorages().get(productIndex - 1).getProduct();

        Product product = new Product(productInShop);
        productStorage.setProduct(product);

        System.out.print("Quantity = ");
        int quantity = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
        int quantityOfProduct = shop.getProductStorages().get(productIndex - 1).getQuantity();
        if (quantity > quantityOfProduct) {
            throw new NotEnoughProductException();
        }

        productStorage.setQuantity(quantity);
        shop.getProductStorages().get(productIndex - 1).setQuantity(quantityOfProduct - quantity);

        return productStorage;
    }

    private Client getClient() throws ClientNotFoundException {
        String firstName;
        String lastName;
        String email;

        System.out.print("\nEnter your first name: ");
        firstName = ConsoleUtility.getScanner().nextLine();

        System.out.print("Enter your second name: ");
        lastName = ConsoleUtility.getScanner().nextLine();

        System.out.print("Enter your email: ");
        email = ConsoleUtility.getScanner().nextLine();

        Client client = ClientController.getInstance().get(new Client(firstName, lastName, email));

        return new Client(client);
    }

    private double getPrice(List<ProductStorage> productStorages){
        double price = 0;
        for (ProductStorage item : productStorages){
            price += item.getQuantity() * item.getProduct().getPrice();
        }

        return price;
    }

    private List<Shop> cloneShops(List<Shop> shops){
        List<Shop> clone = new ArrayList<>();
        for(Shop shop : shops){
            clone.add(new Shop(shop));
        }

        return clone;
    }
}
