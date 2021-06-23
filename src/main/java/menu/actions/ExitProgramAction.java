package menu.actions;

public class ExitProgramAction implements Action{
    @Override
    public void doAction(int index) {
        System.exit(0);
    }
}
