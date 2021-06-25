package menu.actions.menu;

import menu.actions.Action;

public class ExitProgramAction implements Action {
    @Override
    public void doAction(int index) {
        System.exit(0);
    }
}
