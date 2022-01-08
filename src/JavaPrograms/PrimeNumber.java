package JavaPrograms;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        int number = scanner.nextInt();
        if(isPrimeNumber(number))
            System.out.println("It's a prime number");
        else 
            System.out.println("Not a prime number");
    }

    private static boolean isPrimeNumber(int number) {
        for (int i=2;i<number;i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
}
