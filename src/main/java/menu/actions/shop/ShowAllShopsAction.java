package menu.actions.shop;

import controllers.ShopController;
import menu.actions.Action;
import model.entities.Shop;

import java.util.List;

public class ShowAllShopsAction implements Action {
    @Override
    public void doAction(int index) {
        List<Shop> shops = (List<Shop>) ShopController.getInstance().getAll();

        if (shops.size() != 0) {
            for (Shop shop : shops) {
                System.out.println(shop.toString() + '\n');
            }
        } else {
            System.out.println("The shop list is empty.\n");
        }
    }
}
