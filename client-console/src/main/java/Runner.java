import initializers.ContextInitializer;
import initializers.DataInitializer;
import initializers.Initializer;
import initializers.MenuInitializer;
import menu.starter.MenuStarter;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<Initializer> initializers = Arrays.asList(
                new DataInitializer(),
                new ContextInitializer(),
                new MenuInitializer()
        );
        initializers.forEach(Initializer::init);

        MenuStarter.start();
    }
}
