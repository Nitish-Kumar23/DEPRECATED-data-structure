package Arrays;

import Utils.ArrayUtils;

import java.util.Arrays;

public class ArrayConcatenation {
    /**
     * Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
     * <p>
     * Specifically, ans is the concatenation of two nums arrays.
     * <p>
     * Return the array ans.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,1]
     * Output: [1,2,1,1,2,1]
     * Explanation: The array ans is formed as follows:
     * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
     * - ans = [1,2,1,1,2,1]
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,3,2,1]
     * Output: [1,3,2,1,1,3,2,1]
     * Explanation: The array ans is formed as follows:
     * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
     * - ans = [1,3,2,1,1,3,2,1]
     */


    public static void main(String[] args) {
        int[] array = ArrayUtils.getArrayInt();
        System.out.println(Arrays.toString(getArrayConcatenationOptimized(array)));
    }

    private static int[] getArrayConcatenation(int[] array) {
        int size = array.length;
        int[] output = new int[2 * array.length];
        for (int i = 0; i < output.length; i++) {
            if (i < size) {
                output[i] = array[i];
            } else {
                output[i] = array[i - size];
            }
        }
        return output;
    }

    private static int[] getArrayConcatenationOptimized(int[] array) {
        int size = array.length;
        int[] output = new int[2 * array.length];
        for (int i = 0; i < array.length; i++) {
           output[i] = array[i];
           output[i+size] = array[i];
        }
        return output;
    }
}
