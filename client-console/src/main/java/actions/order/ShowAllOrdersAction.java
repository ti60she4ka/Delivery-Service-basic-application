package actions.order;

import actions.Action;
import controllers.OrderController;
import java.util.List;
import model.entities.Order;

public class ShowAllOrdersAction implements Action {

  @Override
  public void doAction(int index) throws Exception {
    List<Order> orders = (List<Order>) OrderController.getInstance().getAll();

    if (orders.size() != 0) {
      for (Order order : orders) {
        System.out.println(order.toString() + '\n');
      }
    } else {
      System.out.println("The order list is empty.\n");
    }
  }
}
