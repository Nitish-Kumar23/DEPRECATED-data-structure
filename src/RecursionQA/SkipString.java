package RecursionQA;

public class SkipString {
    public static void main(String[] args) {
        System.out.println(skipString("bcappledhj","apple",""));
    }

    private static String skipString(String input, String str,String output) {
        if(input.isEmpty()){
            return output;
        }
        if(input.startsWith(str)){
            return skipString(input.substring(str.length()),str,output);
        }
        return skipString(input.substring(1),str,output+input.charAt(0));
    }
}
