package RecursionExp;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        System.out.println(subset(new int[]{-1, 1, 2}));
    }

    /**
     * time complexity - O(N*2^N)
     * space complexity - O(2^N*N)
     *
     * @param arr
     * @return
     */
    private static ArrayList<List<Integer>> subset(int[] arr) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        result.add(new ArrayList<>());
        list.add(arr[0]);
        result.add(list);
        for (int j = 1; j < arr.length; j++) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> list1 = new ArrayList<>(result.get(i));
                list1.add(arr[j]);
                //handle if there are duplicate elements in the array then skip
                if (result.contains(list1)) {
                    continue;
                }
                result.add(list1);
            }
        }
        return result;
    }

//    private static ArrayList<List<Integer>> subset(int[] arr) {
//        ArrayList<List<Integer>> result = new ArrayList<>();
//        result.add(new ArrayList<>(arr[0]));
//        for (Integer num : arr){
//            int size = result.size();
//            for (int i=0;i<size;i++) {
//                ArrayList<Integer> list1 = new ArrayList<>(result.get(i));
//                list1.add(num);
//                result.add(list1);
//            }
//        }
//        return result;
//    }
}
