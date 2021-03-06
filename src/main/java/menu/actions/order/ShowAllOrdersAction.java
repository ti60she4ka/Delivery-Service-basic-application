package menu.actions.order;

import controllers.OrderController;
import menu.actions.Action;
import model.entities.Order;

import java.util.List;

public class ShowAllOrdersAction implements Action {
    @Override
    public void doAction(int index) throws Exception {
        List<Order> orders = OrderController.getInstance().getAll();

        if (orders.size() != 0) {
            for (Order order : orders) {
                System.out.println(order.toString() + '\n');
            }
        } else {
            System.out.println("The order list is empty.\n");
        }
    }
}
