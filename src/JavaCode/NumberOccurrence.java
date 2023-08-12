package JavaCode;

import java.util.Scanner;

public class NumberOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int digit = scanner.nextInt();
        int reminder = 0;
        int count = 0;
        while (number > 0) {
            reminder = number % 10;
            if (reminder == digit) {
                count++;
            }
            number = number / 10;
        }
        System.out.println("Digit " + digit + " occurred " + count + " times");
    }
}
