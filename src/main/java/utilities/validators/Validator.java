package utilities.validators;

import exceptions.FileIsNotValidException;
import exceptions.FilePathIsNotValidException;

import java.io.IOException;

public interface Validator {
    boolean validate(String path) throws FileIsNotValidException, FilePathIsNotValidException, IOException;
}
