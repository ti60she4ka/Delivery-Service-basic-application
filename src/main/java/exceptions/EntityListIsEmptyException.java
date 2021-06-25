package exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EntityListIsEmptyException extends Exception {
    String entityType;

    @Override
    public String getMessage() {
        return "The " + entityType.toLowerCase() + " list is empty.";
    }
}
