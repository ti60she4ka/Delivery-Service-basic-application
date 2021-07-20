package by.exposit.utilities;

import java.util.Scanner;
import lombok.Getter;

public class ConsoleUtility {

  @Getter
  private static final Scanner scanner = new Scanner(System.in);

  private ConsoleUtility() {
  }
}
