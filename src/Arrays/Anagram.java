package Arrays;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        int[] charactersT = new int[26];
        for(int i=0;i<t.length();i++){
            charactersT[t.charAt(i)-'a'] = charactersT[t.charAt(i)-'a'] + 1;
        }
        int[] charactersS = new int[26];
        for(int i=0;i<s.length();i++){
            charactersS[s.charAt(i)-'a'] = charactersS[s.charAt(i)-'a'] + 1;
        }
        for(int i=0;i<charactersT.length;i++){
            if(charactersT[i]!=charactersS[i]){
                return false;
            }
        }
        return true;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        for(String s:strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            if(map.containsKey(sortedKey)){
                List<String> list = map.get(sortedKey);
                list.add(s);
                map.put(sortedKey,list);
            }else{
                List<String> list = new ArrayList();
                list.add(s);
                map.put(sortedKey,list);
            }
        }
        return new LinkedList<>(map.values());
    }

//    public static void topKFrequent(int[] nums, int k) {
//        Map<Integer,Integer> map = new HashMap();
//        for(int i=0;i<nums.length;i++){
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],nums[i]+1);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
//        List<Map.Entry<Integer, Integer> > list
//                = new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet());        
//       Collections.sort(list, Map.Entry.comparingByValue());
//        for (int num : list) {
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                if (entry.getValue().equals(num)) {
//                    sortedMap.put(entry.getKey(), num);
//                }
//            }
//        }
//        System.out.println(sortedMap);
//    }

    public static void main(String[] args) {
//        System.out.println(isAnagram("anagram","nagaram"));
        String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
//        topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
    
}
