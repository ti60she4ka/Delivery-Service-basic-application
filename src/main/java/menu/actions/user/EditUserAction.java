package menu.actions.user;

import controllers.UserController;
import exceptions.UserCannotBeAddedException;
import exceptions.EntityNotFoundException;
import menu.actions.Action;
import model.entities.User;
import utilities.ConsoleUtility;

import java.util.List;

public class EditUserAction implements Action {
    @Override
    public void doAction(int index) throws EntityNotFoundException, UserCannotBeAddedException {
        List<User> users = (List<User>) UserController.getInstance().getAll();

        if (users.size() == 0) {
            System.out.println("The user list is empty.\n");
            return;
        }

        printListOfUsers(users);

        System.out.print("Enter ID of the user who you want to edit: ");

        long id = Long.parseLong(ConsoleUtility.getScanner().nextLine());
        User user = UserController.getInstance().getById(id);

        editUser(user);
    }

    private void printListOfUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user.toString() + '\n');
        }
    }

    private void editUser(User user) throws UserCannotBeAddedException {
        System.out.print("1) First name\n"
                + "2) Last name\n"
                + "3) Email\n"
                + "Select the field you want to edit: ");

        int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

        System.out.println();
        switch (choice){
            case 1:
                System.out.print("Enter a new first name: ");
                user.setFirstName(ConsoleUtility.getScanner().nextLine());
                break;
            case 2:
                System.out.print("Enter a new last name: ");
                user.setLastName(ConsoleUtility.getScanner().nextLine());
                break;
            case 3:
                System.out.print("Enter a new email: ");
                user.setEmail(getNewEmail());
                break;
            default:
                System.out.println("There is no such item in the menu.");
        }
        System.out.println();
    }

    private String getNewEmail() throws UserCannotBeAddedException {
        String email = ConsoleUtility.getScanner().nextLine();
        if(UserController.getInstance().getAll().stream()
                .anyMatch(client -> client.getEmail().equalsIgnoreCase(email))){

            throw new UserCannotBeAddedException(email);
        }

        return email;
    }
}
