package by.exposit.main;

import by.exposit.initializers.MenuInitializer;
import by.exposit.menu.starter.MenuStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner implements CommandLineRunner {

  @Autowired
  private MenuInitializer menuInitializer;

  public static void main(String[] args) {
    SpringApplication.run(Runner.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    menuInitializer.init();
    MenuStarter.start();
  }
}
