package validators;

import java.io.IOException;

public interface Validator {
    void validate(String path) throws IOException;
}
