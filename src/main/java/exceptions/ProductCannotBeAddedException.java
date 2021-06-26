package exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCannotBeAddedException extends EntityCannotBeAddedException {
    String name;

    @Override
    public String getMessage() {
        return "Product with name = '" + name + "' already exists.\n";
    }
}
