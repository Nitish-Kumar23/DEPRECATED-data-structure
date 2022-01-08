package JavaPrograms;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        //find largest of 3 integers
        if(a>b && a>c){
            System.out.println("largest number is "+ a);
        }else if(b>a && b>c){
            System.out.println("largest number is "+b);
        }else {
            System.out.println("largest number is "+c);
        }
    }
}
