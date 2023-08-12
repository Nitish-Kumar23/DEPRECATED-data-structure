package RecursionQA;

public class SkipCharacter {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        System.out.println(skipCharacter("baccad", 'a'));
        System.out.println(skipCharacterV2("baccad", 'a', ""));
    }

    private static String skipCharacter(String input, char skipCh) {
        return getSkippedCharacterString(input, skipCh, 0, result).toString();
    }

    private static StringBuilder getSkippedCharacterString(String input, char character, int index, StringBuilder result) {
        if (input.length() == index) {
            return result;
        }
        if (!(input.charAt(index) == character)) {
            result.append(input.charAt(index));
        }
        return getSkippedCharacterString(input, character, index + 1, result);
    }

    private static String skipCharacterV2(String input, char character, String output) {
        if (input.isEmpty()) {
            return output;
        }
        if (input.charAt(0) == character) {
            return skipCharacterV2(input.substring(1), character, output);
        }
        return skipCharacterV2(input.substring(1), character, output + input.charAt(0));
    }
}
