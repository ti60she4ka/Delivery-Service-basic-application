package by.exposit.actions.user;

import by.exposit.actions.Action;
import by.exposit.controllers.UserController;
import by.exposit.exceptions.EntityNotFoundException;
import by.exposit.model.entities.User;
import by.exposit.utilities.ConsoleUtility;
import java.util.List;

public class DeleteUserAction implements Action {

  private final UserController userController;

  public DeleteUserAction(UserController userController) {
    this.userController = userController;
  }

  @Override
  public void doAction(int index) throws EntityNotFoundException {
    List<User> users = (List<User>) userController.getAll();

    if (users.size() == 0) {
      System.out.println("The user list is empty.\n");
      return;
    }

    printListOfUsers(users);

    System.out.print("Enter ID of the user who you want to delete: ");
    long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
    userController.deleteById(id);

    System.out.println("\nClient with the specified ID was successfully deleted.\n");
  }

  private void printListOfUsers(List<User> users) {
    for (User user : users) {
      System.out.println(user.toString() + '\n');
    }
  }
}
