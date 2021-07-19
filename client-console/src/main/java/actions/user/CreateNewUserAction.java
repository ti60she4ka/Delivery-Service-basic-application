package actions.user;

import actions.Action;
import controllers.UserController;
import exceptions.EntityCannotBeAddedException;
import model.entities.User;
import utilities.ConsoleUtility;

public class CreateNewUserAction implements Action {

  @Override
  public void doAction(int index) throws EntityCannotBeAddedException {
    User user = getNewUser();

    UserController.getInstance().create(user);
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
