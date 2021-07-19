package exceptions;

public class UserNotFoundException extends Exception {

  @Override
  public String getMessage() {
    return "The user with the entered data was not found in the database.\n";
  }
}
