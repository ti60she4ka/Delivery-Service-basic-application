package by.exposit.core.validators;

import by.exposit.core.reader.TextReader;
import by.exposit.core.exceptions.FileIsNotValidException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class JSONValidator implements Validator {

  @Override
  public void validate(String path) throws IOException {
    String text = TextReader.readFromFile(path);

    if (!isBracketsValid(text)) {
      throw new FileIsNotValidException(path);
    }
  }

  private boolean isBracketsValid(String text) {
    Deque<Character> brackets = new ArrayDeque<>();
    String startBrackets = "{[";
    String endBrackets = "}]";
    for (int i = 0; i < text.length(); i++) {
      char symbol = text.toCharArray()[i];

      if (startBrackets.indexOf(symbol) >= 0) {
        brackets.push(symbol);
        continue;
      }

      if (endBrackets.indexOf(symbol) >= 0) {
        if (brackets.isEmpty()) {
          return false;
        }

        char bracket = brackets.pop();

        if (startBrackets.indexOf(bracket) != endBrackets.indexOf(symbol)) {
          return false;
        }
      }
    }

    return brackets.isEmpty();
  }
}
