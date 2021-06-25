package menu.actions.menu;

import menu.MenuContext;
import menu.actions.Action;

public class GoToPreviousMenuAction implements Action {
    @Override
    public void doAction(int index) {
        MenuContext.setMenu(MenuContext.getMenu().getPreviousMenu());
    }
}
