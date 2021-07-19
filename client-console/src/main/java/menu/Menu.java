package menu;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import utilities.ConsoleUtility;

@Getter
@Setter
public class Menu {

  private List<MenuItem> menuItems;
  private Menu previousMenu;

  public void executeMenuItem() {
    try {
      int choice = Integer.parseInt(ConsoleUtility.getScanner().nextLine());
      System.out.println();

      menuItems.get(choice - 1).getAction().doAction(choice - 1);
    } catch (NumberFormatException exception) {
      System.out.println("\nInvalid data entered.\n");
    } catch (IndexOutOfBoundsException exception) {
      System.out.println("\nThere is no such item in the menu.\n");
    } catch (Exception exception) {
      System.out.println('\n' + exception.getMessage());
    }
  }
}
