package RecursionExp;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        stringPermutation("abc", "");
        System.out.println(stringPermutationV2("abc", ""));
        System.out.println(permutationsCount("abc", ""));
    }

    /**
     * @param input
     * @param output
     */
    private static void stringPermutation(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String last = output.substring(i);
            stringPermutation(input.substring(1), first + input.charAt(0) + last);
        }
    }

    /**
     * returns the permutations in an arraylist
     *
     * @param input
     * @param output
     * @return
     */
    private static ArrayList<String> stringPermutationV2(String input, String output) {
        if (input.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String last = output.substring(i);
            list.addAll(stringPermutationV2(input.substring(1), first + input.charAt(0) + last));
        }
        return list;
    }

    private static int permutationsCount(String input, String output) {
        if (input.isEmpty()) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String last = output.substring(i);
            count += permutationsCount(input.substring(1), first + input.charAt(0) + last);
        }
        return count;
    }
}
