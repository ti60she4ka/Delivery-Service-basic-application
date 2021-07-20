package by.exposit.actions.user;

import by.exposit.actions.Action;
import by.exposit.controllers.UserController;
import by.exposit.exceptions.EntityCannotBeAddedException;
import by.exposit.model.entities.User;
import by.exposit.utilities.ConsoleUtility;

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
