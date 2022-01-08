package JavaPrograms;

import java.util.Scanner;

public class CaseCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().trim().charAt(0);
        System.out.println(input);
        
        if(input>='a' && input<='z'){
            System.out.println("Lowercase");
        }else if(input>='A' && input<='Z') {
            System.out.println("Uppercase");
        }
    }
}
