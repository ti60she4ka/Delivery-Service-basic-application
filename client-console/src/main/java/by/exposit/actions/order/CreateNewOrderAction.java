package by.exposit.actions.order;

import by.exposit.actions.Action;
import by.exposit.controllers.OrderController;
import by.exposit.model.entities.Order;

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
