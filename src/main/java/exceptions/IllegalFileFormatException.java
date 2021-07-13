package exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IllegalFileFormatException extends RuntimeException {
    String path;
    String fileType;

    @Override
    public String getMessage() {
        return "File with path = '" + path + "' is not a " + fileType + " file.";
    }
}
