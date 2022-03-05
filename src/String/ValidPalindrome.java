package String;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isValidPalindrome("0P"));
    }

    private static boolean isValidPalindrome(String input) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<input.length();i++){
            if(!Character.isLetterOrDigit(input.charAt(i))){
                continue;
            }
            if(Character.isDigit(input.charAt(i))) {
                result.append(input.charAt(i));
            }
            if(Character.isLetter(input.charAt(i))) {
                result.append(Character.toLowerCase(input.charAt(i)));
            }
        }
        String ans = result.toString();
        int i=0,j=ans.length()-1;
        while (i<j){
            if(ans.charAt(i)!=ans.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
