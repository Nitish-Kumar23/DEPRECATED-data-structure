package RecursionQA;

import java.util.*;

public class PermutationExists {
    public static void main(String[] args) {
        /**
         * "prosperity"
         * "properties"
         */
        System.out.println(checkInclusion("prosperity","properties"));
    }

    private static boolean checkInclusion(String s1, String s2) {
        List<String> permutations = getPermutations(s1,"");
        for (String value : permutations){
            if(s2.contains(value)){
                return true;
            }
        }
        return false;
    }

    private static List<String> getPermutations(String input,String output) {
        if(input.isEmpty()){
            return Arrays.asList(output);
        }
        List<String> result = new ArrayList<>();
        for (int i=0;i<=output.length();i++){
            String first = output.substring(0,i);
            String last = output.substring(i);
            result.addAll(getPermutations(input.substring(1),first+input.charAt(0)+last));
        }
        return result;
    }

    /**
    public boolean checkInclusionV1(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        Map<Character,Integer> map = new HashMap<>(26);
        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            map.put(c,1);
        }
        int start=0,end=s1.length();
        Map<Character,Integer> s2CharCountMap = new HashMap<>();
        while(start<=end){
            char character = s2.charAt(start);
            if(map.containsKey(character))
            start++;
            end++;
        }
    }
     **/
}
