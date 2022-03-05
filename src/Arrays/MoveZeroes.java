package Arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroesV1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            if(arr[i]!=0) {
                queue.add(arr[i]);
            }
        }
        int index = 0;
        while (!queue.isEmpty()){
            arr[index++] = queue.poll();
        }
        for (int i=index;i<arr.length;i++){
            arr[i] = 0;
        }
    }

    /**
     * add non zeroes elements at the start of arrays.  add zeroes later
     * @param arr
     */
    private static void moveZeroesV1(int[] arr) {
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[index++]=arr[i];
            }
        }
        for(int i=index;i<arr.length;i++){
            arr[i] = 0;
        }
    }
}
