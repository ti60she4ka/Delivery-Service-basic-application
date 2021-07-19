package actions.order;

import actions.Action;
import controllers.OrderController;
import model.entities.Order;

public class CreateNewOrderAction implements Action {

  @Override
  public void doAction(int index) throws Exception {
    OrderController.getInstance().create(Order.builder().build());
    System.out.println("\nThe order was successfully added.\n");
  }
}
