package Arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        System.out.println(maximumSumSubArray(new int[]{1, 9, -1, -2, 7, 3, -1, 2}, 4));
        System.out.println(maximumSumSubArrayV1(new int[]{1, 9, -1, -2, 7, 3, -1, 2}, 4));
        System.out.println(maximumSumSubArrayV2(new int[]{1, 9, -1, -2, 7, 3, -1, 2}, 4));
    }

    /**
     * Brute force approach
     * Time complexity - O(n*k) - outer loop runs n times in worst case and for each iteration
     * we are looping again k times(window size)
     *
     * @param arr
     * @param k
     * @return
     */
    private static int maximumSumSubArray(int[] arr, int k) {
        int wSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - k; i++) {
            wSum = arr[i];
            for (int j = i + 1; j <= (i + k - 1); j++) {
                wSum = wSum + arr[j];
            }
            if (wSum > maxSum) {
                maxSum = wSum;
            }
        }
        return maxSum;
    }

    private static int maximumSumSubArrayV1(int[] arr, int k) {
        int wSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int wStart = 0;
        int wEnd = 0;
        for (int i = 0; i < arr.length - k; i++) {
            wSum = arr[i];
            for (int j = i + 1; j <= (i + k - 1); j++) {
                wSum = wSum + arr[j];
            }
            if (wSum > maxSum) {
                maxSum = wSum;
                wStart = i;
                wEnd = i + k - 1;
            }
        }
        System.out.println("Window range - (" + wStart + "," + wEnd + ")");
        return maxSum;
    }

    /**
     * sliding window -> add the element which is new in sliding window in existing sum and 
     * subtract the element which got removed from window, keep updating maximum sum
     * TIme complexity - both loops are iterating at max n times : O(n)
     * @param arr
     * @param k
     * @return
     */
    private static int maximumSumSubArrayV2(int[] arr, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        for (int end = k; end < arr.length; end++) {
            windowSum += arr[end] - arr[end - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return maxSum;
    }
}
