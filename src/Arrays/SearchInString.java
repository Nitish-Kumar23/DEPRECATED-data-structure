package Arrays;

public class SearchInString {
    public static void main(String[] args) {
        String input = "machine";
        char target = 'n';
        System.out.println("character exists at index " + search(input, target));
        System.out.println("Element exists " + elementExists(input, target));
    }

    /**
     * @param input
     * @param target
     * @return
     */
    private static int search(String input, char target) {
        if (input == null || input.length() == 0) {
            return -1;
        }
        for (int index = 0; index < input.length(); index++) {
            if (target == input.charAt(index))
                return index;
        }
        return -1;
    }

    private static boolean elementExists(String input, char target) {
        if (input == null || input.length() == 0)
            return false;
        for (char value : input.toCharArray()) {
            if (value == target)
                return true;
        }
        return false;
    }
}
