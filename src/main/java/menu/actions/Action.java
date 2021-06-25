package menu.actions;

import exceptions.EntityNotFoundException;

public interface Action {
    void doAction(int index) throws Exception;
}
