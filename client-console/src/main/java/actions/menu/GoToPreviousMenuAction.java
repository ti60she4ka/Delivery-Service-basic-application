package actions.menu;

import menu.MenuContext;
import actions.Action;

public class GoToPreviousMenuAction implements Action {
    @Override
    public void doAction(int index) {
        MenuContext.setMenu(MenuContext.getMenu().getPreviousMenu());
    }
}
