package exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientCannotBeAddedException extends EntityCannotBeAddedException {
    private final String email;

    @Override
    public String getMessage() {
        return "Client with email = " + email + " already exists.\n";
    }
}
