package JavaPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().trim().charAt(0);
        System.out.println(input);

        if (input >= 'a' && input <= 'z') {
            System.out.println("Lowercase");
        } else if (input >= 'A' && input <= 'Z') {
            System.out.println("Uppercase");
        }
        variableLength(1, 42, 546, 24);
    }

    private static void variableLength(int... arguments) {
        System.out.println(Arrays.toString(arguments));
    }
}
