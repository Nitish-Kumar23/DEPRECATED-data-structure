package String;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] arr = new char[]{'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseString(char[] s) {
        int start=0,end=s.length-1;
        while(start<=end){
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}
