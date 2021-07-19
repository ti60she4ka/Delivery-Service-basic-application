package exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileFormatNotSupportedException extends RuntimeException {

  private final String path;

  @Override
  public String getMessage() {
    return "The file format '" + path + "' is not supported";
  }
}
