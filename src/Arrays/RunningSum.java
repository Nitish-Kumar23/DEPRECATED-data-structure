package Arrays;

import java.util.Arrays;

public class RunningSum {
    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     * <p>
     * Return the running sum of nums.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4]
     * Output: [1,3,6,10]
     * Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [1,1,1,1,1]
     * Output: [1,2,3,4,5]
     * Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
     * <p>
     * Example 3:
     * <p>
     * Input: nums = [3,1,2,10,1]
     * Output: [3,4,6,16,17]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(runningSum(arr)));
    }

    private static int[] runningSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sum + arr[i];
            sum = arr[i];
        }
        return arr;
    }
}
