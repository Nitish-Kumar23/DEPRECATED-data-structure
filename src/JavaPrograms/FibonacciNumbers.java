package JavaPrograms;

import java.util.Scanner;

public class FibonacciNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //nth fibonacci number
        System.out.println(n + "th Fibonacci number is " + getNthFibo(n));
    }
    
    private static int getNthFibonacciNumber(int n){
        int a = 0;
        int b = 1;
        int result = 0;
        if (n == 0 || n == 1) {
            return a == n ? a : b;
        }
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
    
    /**recursive solution**/
    private static int getNthFibo(int n){
        //base condition
        if(n==0)
            return 0;
        if (n==1)
            return 1;
        return getNthFibo(n-1)+getNthFibo(n-2);
    }
    
    
}
