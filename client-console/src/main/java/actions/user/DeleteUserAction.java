package actions.user;

import actions.Action;
import controllers.UserController;
import exceptions.EntityNotFoundException;
import java.util.List;
import model.entities.User;
import utilities.ConsoleUtility;

public class DeleteUserAction implements Action {

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<User> users = (List<User>) UserController.getInstance().getAll();

    if (users.size() == 0) {
      System.out.println("The user list is empty.\n");
      return;
    }

    printListOfUsers(users);

    System.out.print("Enter ID of the user who you want to delete: ");
    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
    UserController.getInstance().deleteById(id);

    System.out.println("\nClient with the specified ID was successfully deleted.\n");
  }

  private void printListOfUsers(List<User> users) {
    for (User user : users) {
      System.out.println(user.toString() + '\n');
    }
  }
}
