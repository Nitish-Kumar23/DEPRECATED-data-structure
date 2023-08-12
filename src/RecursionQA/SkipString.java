package RecursionQA;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipString("bcappledhj", "apple", ""));
        System.out.println(skipStringWhenNotEquals("bcappledhj", "app", "apple", ""));
    }

    private static String skipString(String input, String str, String output) {
        if (input.isEmpty()) {
            return output;
        }
        if (input.startsWith(str)) {
            return skipString(input.substring(str.length()), str, output);
        }
        return skipString(input.substring(1), str, output + input.charAt(0));
    }

    private static String skipStringWhenNotEquals(String input, String str, String negative, String output) {
        if (input.isEmpty()) {
            return output;
        }
        if (input.startsWith(str) && !input.startsWith(negative)) {
            return skipStringWhenNotEquals(input.substring(str.length()), str, negative, output);
        }
        return skipStringWhenNotEquals(input.substring(1), str, negative, output + input.charAt(0));
    }
}
