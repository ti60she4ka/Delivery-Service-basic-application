package by.exposit.actions.menu;

import by.exposit.actions.Action;
import by.exposit.menu.MenuContext;

public class GoToPreviousMenuAction implements Action {

  @Override
  public void doAction(int index) {
    MenuContext.setMenu(MenuContext.getMenu().getPreviousMenu());
  }
}
