package main;

import initializers.ContextInitializer;
import initializers.DataInitializer;
import initializers.Initializer;
import initializers.MenuInitializer;
import java.util.Arrays;
import java.util.List;
import menu.starter.MenuStarter;

public class Runner {

  public static void main(String[] args) {
    List<Initializer> initializers =
        Arrays.asList(new DataInitializer(), new ContextInitializer(), new MenuInitializer());
    initializers.forEach(Initializer::init);

    MenuStarter.start();
  }
}
