package exceptions;

public class NotEnoughProductException extends Exception {
    @Override
    public String getMessage() {
        return "This product is not available in such quantity.\n";
    }
}
