package actions.shop;

import controllers.ShopController;
import exceptions.EntityCannotBeAddedException;
import actions.Action;
import model.entities.Shop;
import utilities.ConsoleUtility;

public class CreateNewShopAction implements Action {
    @Override
    public void doAction(int index) throws EntityCannotBeAddedException {
        Shop shop = getNewShop();

        ShopController.getInstance().create(shop);
        System.out.println("\nNew shop added successfully!\n");
    }

    private Shop getNewShop() {
        String name;
        String city;
        System.out.println("Enter the shop information:");

        System.out.print("Name — ");
        name = ConsoleUtility.getScanner().nextLine();

        System.out.print("City — ");
        city = ConsoleUtility.getScanner().nextLine();

        return Shop.builder().name(name).city(city).build();
    }
}
