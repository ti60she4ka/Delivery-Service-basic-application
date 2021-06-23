package menu.actions;

import menu.MenuContext;

public class GoToPreviousMenuAction implements Action {
    @Override
    public void doAction(int index) {
        MenuContext.setMenu(MenuContext.getMenu().getPreviousMenu());
    }
}
