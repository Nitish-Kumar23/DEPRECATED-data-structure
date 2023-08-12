package RecursionExp;

import java.util.ArrayList;

public class Subsequence {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        subsequence("abc", "");
        System.out.println(subsequenceV2("abc", ""));
        System.out.println(subsequenceV3("abc", ""));
    }

    private static void subsequence(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        subsequence(input.substring(1), output + input.charAt(0));
        subsequence(input.substring(1), output);
    }

    private static ArrayList<String> subsequenceV2(String input, String output) {
        if (input.isEmpty()) {
            result.add(output);
            return result;
        }
        subsequenceV2(input.substring(1), output + input.charAt(0));
        subsequenceV2(input.substring(1), output);
        return result;
    }

    private static ArrayList<String> subsequenceV3(String input, String output) {
        if (input.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }
        ArrayList<String> left = subsequenceV3(input.substring(1), output + input.charAt(0));
        ArrayList<String> right = subsequenceV3(input.substring(1), output);
        left.addAll(right);
        return left;
    }
}
