package by.exposit.client.actions.user;

import by.exposit.client.actions.Action;
import by.exposit.core.controllers.UserController;
import by.exposit.core.exceptions.EntityCannotBeAddedException;
import by.exposit.core.model.entities.User;
import by.exposit.client.utilities.ConsoleUtility;

public class CreateNewUserAction implements Action {

  private final UserController userController;

  public CreateNewUserAction(UserController userController) {
    this.userController = userController;
  }

  @Override
  public void doAction(int index) throws EntityCannotBeAddedException {
    User user = getNewUser();

    userController.create(user);
    System.out.println("\nNew user added successfully!\n");
  }

  private User getNewUser() {
    String firstName;
    String secondName;
    String email;
    System.out.println("Enter the user information:");

    System.out.print("First name — ");
    firstName = ConsoleUtility.getScanner().nextLine();

    System.out.print("Last name — ");
    secondName = ConsoleUtility.getScanner().nextLine();

    System.out.print("Email — ");
    email = ConsoleUtility.getScanner().nextLine();

    return User.builder().firstName(firstName).lastName(secondName).email(email).build();
  }
}
