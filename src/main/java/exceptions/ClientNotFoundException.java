package exceptions;

public class ClientNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "The client with the entered data was not found in the database.\n";
    }
}
