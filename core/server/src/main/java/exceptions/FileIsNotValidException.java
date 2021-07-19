package exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileIsNotValidException extends RuntimeException {

  private final String path;

  @Override
  public String getMessage() {
    return "File with path = '" + path + "' isn't valid.";
  }
}
