package menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import menu.actions.Action;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
    private String text;
    private Menu submenu;
    private Action action;
}
