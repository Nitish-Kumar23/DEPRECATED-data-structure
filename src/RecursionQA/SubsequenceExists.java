package RecursionQA;

import java.util.ArrayList;
import java.util.List;

class SubsequenceExists {

    boolean ans = false;
    
    public static void main(String[] args) {
        System.out.println(isSubsequence("ahbgdc","axc"));
        System.out.println(isSubsequenceV1("ahbgdc","abc"));
        System.out.println(isSubsequenceV1("abc","b"));
    }

    /**
     * Get all subsequence of the input string if t exists in the list of substrings return true else false
     * 
     * @param input
     * @param s
     * @return
     */
    public static boolean isSubsequence(String input, String s) {
        List<String> subStrings = getSubstrings(input,"");
        System.out.println("all subsequence : "+subStrings);
        if(subStrings.contains(s)){
            return true;
        }
        return false;
    }
    
    public static List<String> getSubstrings(String input, String output) {
        if (input.length() == 0) {
            List<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }
        List<String> ans1 = getSubstrings(input.substring(1), output + input.charAt(0));
        List<String> ans2 = getSubstrings(input.substring(1), output);
        ans1.addAll(ans2);
        return ans1;
    }

    /**
     * using two pointers compare character of both strings increment if equal
     * 
     * @param input
     * @param s
     * @return
     */
   public static boolean isSubsequenceV1(String input, String s){
        int inputCounter = 0;
        int sCounter = 0;
        if(input.isEmpty()){
            return true;
        }
        while (inputCounter<input.length()&& sCounter<s.length()){
            if(input.charAt(inputCounter)==s.charAt(sCounter)){
                inputCounter++;
                sCounter++;
                continue;
            }
            inputCounter++;
        }
        if(sCounter>=s.length()){
            return true;
        }
        return false;
   }
    
    
}