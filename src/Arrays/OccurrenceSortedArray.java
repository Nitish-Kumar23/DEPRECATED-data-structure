package Arrays;

import java.util.Arrays;

public class OccurrenceSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println(Arrays.toString(searchRange(arr,2)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        result[0] = getFirstOccurrence(nums,target);
        result[1] = getLastOccurrence(nums,target);
        return result;
    }

    private static int getLastOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int potentialAns = -1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else {
                potentialAns = mid;
                start = mid+1;
            }
        }
        return potentialAns;
    }

    private static int getFirstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int potentialAns = -1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }else {
                potentialAns = mid;
                end = mid-1;
            }
        }
        return potentialAns;
    }
}
