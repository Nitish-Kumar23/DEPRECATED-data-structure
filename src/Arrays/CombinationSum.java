package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        //[2,3,5]
        //8
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, Boolean> elementVsExistsMap = new HashMap<>();
        int minimumElement = Integer.MAX_VALUE;
        int maximumElement = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            elementVsExistsMap.put(arr[i], true);
            if (arr[i] < minimumElement) {
                minimumElement = arr[i];
            }
            if (arr[i] > maximumElement) {
                maximumElement = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            List<Integer> output = new ArrayList();
            if (arr[i] == target) {
                output.add(arr[i]);
                result.add(output);
                if (elementVsExistsMap.containsKey(0)) {
                    List<Integer> output2 = new ArrayList();
                    output2.add(arr[i]);
                    output2.add(0);
                    result.add(output2);
                }
            }
            int j = 1;
            while (true) {
                List<Integer> list = new ArrayList();
                int value = target - (arr[i] * j);
                if (value >= minimumElement && value <= maximumElement) {
                    if (elementVsExistsMap.containsKey(value)) {
                        list.add(value);
                        for (int k = 1; k <= j; k++) {
                            list.add(arr[i]);
                        }
                        result.add(list);
                    }
                    j++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
