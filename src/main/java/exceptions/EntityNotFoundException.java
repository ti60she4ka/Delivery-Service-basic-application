package exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EntityNotFoundException extends Exception {
    String entityType;
    Long id;

    @Override
    public String getMessage() {
        return entityType + " with ID = " + id + " was not found.";
    }
}
