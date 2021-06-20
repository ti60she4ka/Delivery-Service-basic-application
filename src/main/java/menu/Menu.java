package menu;

import lombok.Getter;
import lombok.Setter;
import utilities.ConsoleUtility;

import java.util.List;

@Getter
@Setter
public class Menu {
    private List<MenuItem> menuItems;
    private Menu previousMenu;

    public void executeMenuItem(){
        try {
            int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());

            MenuItem item = menuItems.get(choice - 1);
            System.out.println();
            item.getAction().doAction(choice - 1);
        } catch (NumberFormatException exception) {
            System.out.println("\nInvalid data entered.\n");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("\nThere is no such item in the menu.\n");
        }
    }
}
