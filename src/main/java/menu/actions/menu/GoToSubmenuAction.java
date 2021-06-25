package menu.actions.menu;

import menu.MenuContext;
import menu.actions.Action;

public class GoToSubmenuAction implements Action {
    @Override
    public void doAction(int index) {
        MenuContext.setMenu(MenuContext.getMenu().getMenuItems().get(index).getSubmenu());
    }
}
