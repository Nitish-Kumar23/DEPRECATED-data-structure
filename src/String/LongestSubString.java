package String;

import java.util.*;

public class LongestSubString {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringV1("abba"));
        System.out.println(lengthOfLongestSubstringV2("abba"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int res = Integer.MIN_VALUE;
        int start=0,end=0;
        String subString = "";
        int count = 0;
        while(start<s.length() && end<s.length()){
            if(!subString.contains(String.valueOf(s.charAt(end)))){
                subString = subString + s.charAt(end);
                count++;
                end++;
            }else if(subString.contains(String.valueOf(s.charAt(end)))){
                count = count-1;
                start++;
            }
            if(count>res){
                res = count;
            }
        }
        return res!=Integer.MIN_VALUE?res:0;
    }

    private static int lengthOfLongestSubstringV1(String s) {
        int res = Integer.MIN_VALUE;
        int start=0,end=0;
        String subString = "";
        int count = 0;
        Map<Character, Integer> charToIndexesMap = new HashMap<>();
        while (start<s.length() && end<s.length()){
            if(!subString.contains(String.valueOf(s.charAt(end)))){
                subString = subString + s.charAt(end);
                end++;
                count++;
            }else {
                start = charToIndexesMap.get(s.charAt(end))+1;
                count = end-start+1;
                end++;
                subString = s.substring(start,end);
            }
            charToIndexesMap.put(s.charAt(end-1),end-1);
            if(count>res)
                res = count;
        }
        return res!=Integer.MIN_VALUE?res:0;
    }

    private static int lengthOfLongestSubstringV2(String s) {
        int res = Integer.MIN_VALUE;
        int start=0,end=0;
        int count = 0;
        Map<Character, Integer> charToIndexesMap = new HashMap<>();
        while (start<s.length() && end<s.length()){
            if(charToIndexesMap.containsKey(s.charAt(end))){
                start = charToIndexesMap.get(s.charAt(end))+1;
                count = end-start+1;
            }else {
                count++;
            }
            charToIndexesMap.put(s.charAt(end),end);
            end++;
            if(count>res)
                res = count;
        }
        return res!=Integer.MIN_VALUE?res:0;
    }
}
