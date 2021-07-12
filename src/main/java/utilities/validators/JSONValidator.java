package utilities.validators;

import exceptions.FileIsNotValidException;
import exceptions.FilePathIsNotValidException;
import utilities.reader.TextReader;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class JSONValidator implements Validator {
    @Override
    public boolean validate(String path) throws FileIsNotValidException, FilePathIsNotValidException, IOException {
        if (path == null || !path.endsWith(".json")) {
            throw new FilePathIsNotValidException(path, "json");
        }

        String text = TextReader.readFromFile(path);

        if(isBracketsValid(text)){
            return true;
        }else{
            throw new FileIsNotValidException(path);
        }
    }

    private boolean isBracketsValid(String text) {
        Stack<Character> brackets = new Stack<>();
        String startBrackets = "{[";
        String endBrackets = "}]";
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.toCharArray()[i];

            if (startBrackets.indexOf(symbol) >= 0) {
                brackets.push(symbol);
                continue;
            }

            if (endBrackets.indexOf(symbol) >= 0) {
                if (brackets.size() == 0) {
                    return false;
                }

                char bracket = brackets.pop();

                if (startBrackets.indexOf(bracket) != endBrackets.indexOf(symbol)) {
                    return false;
                }
            }
        }

        return brackets.size() == 0;
    }
}
