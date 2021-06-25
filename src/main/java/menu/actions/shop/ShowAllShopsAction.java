package menu.actions.shop;

import controllers.ClientController;
import controllers.ShopController;
import menu.actions.Action;
import model.entities.Client;
import model.entities.Shop;

import java.util.List;

public class ShowAllShopsAction implements Action {
    @Override
    public void doAction(int index) {
        List<Shop> shops = ShopController.getInstance().getShops();

        if (shops.size() != 0) {
            for (Shop shop : shops) {
                System.out.println(shop.toString());
                System.out.println();
            }
        } else {
            System.out.println("The shop list is empty.");
            System.out.println();
        }
    }
}
