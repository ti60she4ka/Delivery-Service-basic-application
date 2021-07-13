package utilities.validators;

import java.io.IOException;

public interface Validator {
    boolean validate(String path) throws IOException;
}
