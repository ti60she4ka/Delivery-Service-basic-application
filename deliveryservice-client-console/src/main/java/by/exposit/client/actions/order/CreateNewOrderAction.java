package by.exposit.client.actions.order;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.OrderController;
import by.exposit.core.model.entities.Order;

public class CreateNewOrderAction implements Action {

  private final OrderController orderController;

  public CreateNewOrderAction(OrderController orderController) {
    this.orderController = orderController;
  }

  @Override
  public void doAction(int index) throws Exception {
    orderController.create(Order.builder().build());
    System.out.println("\nThe order was successfully added.\n");
  }
}
