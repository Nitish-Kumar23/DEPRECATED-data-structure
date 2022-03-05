package String;

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWordsV1("Let's take LeetCode contest"));
    }

    private static String reverseWords(String input) {
        StringBuilder res = new StringBuilder();
        String[] arr = input.split(" ");
        for (int i = 0; i < arr.length; i++) {
            res.append(reverseWord(arr[i])).append(" ");
        }
        return res.toString();
    }

    private static String reverseWord(String input) {
        StringBuilder res = new StringBuilder();
        int start = 0, end = input.length() - 1;
        char[] arr = input.toCharArray();
        while (start <= end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return res.append(arr).toString();
    }

    private static String reverseWordsV1(String input) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                while (!stack.isEmpty()) {
                    res.append(stack.pop());
                }
                res.append(" ");
            } else {
                stack.push(input.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }
}
