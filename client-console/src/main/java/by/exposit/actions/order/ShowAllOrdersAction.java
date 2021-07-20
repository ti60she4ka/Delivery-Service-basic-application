package by.exposit.actions.order;

import by.exposit.actions.Action;
import by.exposit.controllers.OrderController;
import by.exposit.model.entities.Order;
import java.util.List;

public class ShowAllOrdersAction implements Action {

  private final OrderController orderController;

  public ShowAllOrdersAction(OrderController orderController) {
    this.orderController = orderController;
  }

  @Override
  public void doAction(int index) throws Exception {
    List<Order> orders = (List<Order>) orderController.getAll();

    if (orders.size() != 0) {
      for (Order order : orders) {
        System.out.println(order.toString() + '\n');
      }
    } else {
      System.out.println("The order list is empty.\n");
    }
  }
}
