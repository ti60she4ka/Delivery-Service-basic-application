package by.exposit.client.menu;

import by.exposit.client.actions.Action;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {

  private String text;
  private Menu submenu;
  private Action action;
}
