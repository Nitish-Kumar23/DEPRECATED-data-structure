package Arrays;

import Utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class BuildArrayPermutation {
    /**
     * Given a zero-based permutation nums (0-indexed), build an array ans of the same length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.
     *
     * A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [0,2,1,5,3,4]
     * Output: [0,1,2,4,5,3]
     * Explanation: The array ans is built as follows: 
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     *     = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
     *     = [0,1,2,4,5,3]
     *     
     *     Example 2:
     *
     * Input: nums = [5,0,1,2,3,4]
     * Output: [4,5,0,1,2,3]
     * Explanation: The array ans is built as follows:
     * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
     *     = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
     *     = [4,5,0,1,2,3]
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = ArrayUtils.getArrayInt();
        int output[] = buildArrayFromPermutation(array);
        System.out.println(Arrays.toString(output));
    }

    private static int[] buildArrayFromPermutation(int[] array) {
        int[] output = new int[array.length];
        for (int index=0;index<array.length;index++){
            output[index] = array[array[index]];
        }
        return output;
    }
}
