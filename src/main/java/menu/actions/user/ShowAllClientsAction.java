package menu.actions.user;

import controllers.UserController;
import menu.actions.Action;
import model.entities.User;

import java.util.List;

public class ShowAllClientsAction implements Action {
    @Override
    public void doAction(int index) {
        List<User> users = UserController.getInstance().getAll();

        if (users.size() != 0) {
            for (User user : users) {
                System.out.println(user.toString() + '\n');
            }
        } else {
            System.out.println("The user list is empty.\n");
        }
    }
}
