package Arrays;

import Utils.ArrayUtils;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.getArrayInt();
        System.out.println(Arrays.toString(reverseArray(arr)));
    }

    private static int[] reverseArray(int[] arr) {
        int end = arr.length - 1;
        for (int start = 0; start < end; start++) {
            Swap.swap(arr, start, end);
            end--;
        }
        return arr;
    }
}
