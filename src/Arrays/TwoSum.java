package Arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {5, 25, 75};
        System.out.println(Arrays.toString(twoSumIndexes(numbers, 100)));
    }

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
            if(mid+1==arr.length && arr[mid]==target){
                return mid;
            }
            if(mid+1<arr.length && arr[mid]==target && arr[mid]!=arr[mid+1]){
                return mid;
            }
            if(mid+1<arr.length && arr[mid]==target && arr[mid]!=arr[mid+1]){
                return mid;
            }
            if(mid+1<arr.length && arr[mid]==target && arr[mid]==arr[mid+1]){
                return mid+1;
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
