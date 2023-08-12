package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 4};
        System.out.println(Arrays.toString(twoSumIndexes(numbers, 100)));
        System.out.println(Arrays.toString(twoSumIndexesV2(numbers, 100)));
        System.out.println(Arrays.toString(twoSumIndexesV3(numbers,6)));
    }

    private static int[] twoSumIndexesV3(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                output[0] = i;
                output[1] = map.get(target-nums[i]);
                return output;
            }
            map.put(nums[i],i);
        }
        return output;
    }

    /**
     * Two pointer approach -> take start and end pointers. if the sum of arr[start] and arr[end] is less than target 
     * then it means we need to increase the sum by moving in right direction(start+1) else move left (end-1)
     *
     * @param arr
     * @param target
     * @return
     */
    private static int[] twoSumIndexesV2(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            if (arr[start] + arr[end] < target) {
                start++;
            }
            if (arr[start] + arr[end] > target) {
                end--;
            }
        }
        return null;
    }

    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    private static int[] twoSumIndexes(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int secondElementIndex = binarySearch(numbers, i, numbers.length - 1, target - numbers[i]);
            if (secondElementIndex != -1) {
                return new int[]{i + 1, secondElementIndex + 1};
            }
        }
        return null;
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid + 1 == arr.length && arr[mid] == target) {
                return mid;
            }
            if (mid + 1 < arr.length && arr[mid] == target && arr[mid] != arr[mid + 1]) {
                return mid;
            }
            if (mid + 1 < arr.length && arr[mid] == target && arr[mid] != arr[mid + 1]) {
                return mid;
            }
            if (mid + 1 < arr.length && arr[mid] == target && arr[mid] == arr[mid + 1]) {
                return mid + 1;
            }
            if (target >= arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
