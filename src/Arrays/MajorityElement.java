package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3,5,3};
        System.out.println(getMajorityElements(arr));
    }

    private static List<Integer> getMajorityElements(int[] arr) {
        int count = arr.length/3;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer element : arr){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else {
                map.put(element,1);
            }
        }
        for(Map.Entry<Integer,Integer> response : map.entrySet()){
            if(response.getValue()>count){
                result.add(response.getKey());
            }
        }
        return result;
    }
}
