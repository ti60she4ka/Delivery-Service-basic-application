package actions.menu;

import actions.Action;
import menu.MenuContext;

public class GoToSubmenuAction implements Action {

  @Override
  public void doAction(int index) {
    MenuContext.setMenu(MenuContext.getMenu().getMenuItems().get(index).getSubmenu());
  }
}
