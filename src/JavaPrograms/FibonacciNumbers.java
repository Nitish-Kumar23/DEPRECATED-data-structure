package JavaPrograms;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //nth fibonacci number
        int a = 0;
        int b = 1;
        int result = 0;
        if (n == 0 || n == 1) {
            System.out.println(n + "th Fibonacci number is " + (a == n ? a : b));
            return;
        }
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        System.out.println(n + "th Fibonacci number is " + result);
    }
}
