package by.exposit.client.actions.menu;

import by.exposit.client.actions.Action;
import by.exposit.client.menu.MenuContext;

public class GoToPreviousMenuAction implements Action {

  @Override
  public void doAction(int index) {
    MenuContext.setMenu(MenuContext.getMenu().getPreviousMenu());
  }
}
