package JavaPrograms;

import RecursionQA.ReverseNumber;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }

    private static boolean isPalindrome(int n) {
        return n==ReverseNumber.getReverse(123212);
    }
}
