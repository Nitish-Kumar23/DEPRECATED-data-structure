package JavaCode;

import java.util.Scanner;

public class ArmStrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(isArmStrongNumber(number));
        print3DigitArmStrongNumbers();
    }

    /**
     * method to print all 3 digits armstrong numbers
     */
    private static void print3DigitArmStrongNumbers() {
        for (int i = 100; i < 1000; i++) {
            if (isArmStrongNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isArmStrongNumber(int number) {
        int sum = 0;
        int original = number;
        while (number > 0) {
            sum = (int) (sum + Math.pow(number % 10, 3));
            number = number / 10;
        }
        return sum == original;
    }
}
