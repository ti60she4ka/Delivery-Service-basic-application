package by.exposit.client.actions.user;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.UserController;
import by.exposit.core.model.entities.User;
import java.util.List;

public class ShowAllClientsAction implements Action {

  private final UserController userController;

  public ShowAllClientsAction(UserController userController) {
    this.userController = userController;
  }

  @Override
  public void doAction(int index) {
    List<User> users = (List<User>) userController.getAll();

    if (users.size() != 0) {
      for (User user : users) {
        System.out.println(user.toString() + '\n');
      }
    } else {
      System.out.println("The user list is empty.\n");
    }
  }
}
