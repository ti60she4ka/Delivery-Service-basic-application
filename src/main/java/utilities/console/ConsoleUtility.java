package utilities.console;

import lombok.Getter;

import java.util.Scanner;

public class ConsoleUtility {
    @Getter
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleUtility(){}
}
