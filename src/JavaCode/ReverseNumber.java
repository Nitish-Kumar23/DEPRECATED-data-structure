package JavaCode;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int reverseNumber = 0;

        /**
         int numCopy = number;
         int numDigits = 0;
         int reverseNumber = 0;
         int reminder = 0;
         while (number>0){
         numDigits++;
         number = number/10;
         }
         number = numCopy;
         int count=1;
         while (number>0){
         reminder = number%10;
         reverseNumber = (int) (reverseNumber+reminder*Math.pow(10.0,(double)(numDigits-count)));
         count++;
         number = number/10;
         }
         **/
        while (number > 0) {
            reverseNumber = reverseNumber * 10 + (number % 10);
            number = number / 10;
        }
        System.out.println("reverse number is " + reverseNumber);
    }

}
