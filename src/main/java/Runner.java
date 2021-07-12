import initializers.DataInitializer;
import initializers.Initializer;
import initializers.MenuInitializer;
import initializers.UtilityInitializer;
import menu.starter.MenuStarter;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<Initializer> initializers = Arrays.asList(
                new UtilityInitializer(),
                new MenuInitializer(),
                new DataInitializer()
        );
        initializers.forEach(Initializer::init);

        MenuStarter.start();
    }
}
