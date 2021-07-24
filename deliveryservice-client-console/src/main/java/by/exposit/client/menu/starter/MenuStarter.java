package by.exposit.client.menu.starter;

import by.exposit.client.menu.MenuContext;

public class MenuStarter {

  public static void start() {
    while (true) {
      for (int i = 0; i < MenuContext.getMenu().getMenuItems().size(); i++) {
        System.out.println((i + 1) + ". " + MenuContext.getMenu().getMenuItems().get(i).getText());
      }
      System.out.print("Select item from the menu: ");
      MenuContext.getMenu().executeMenuItem();
    }
  }
}
