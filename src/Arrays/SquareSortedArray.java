package Arrays;

import java.util.Arrays;

public class SquareSortedArray {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
        System.out.println(Arrays.toString(sortedSquaresV1(arr)));
    }

    /**
     * using two pointers compare extreme left and right
     * time complexity - O(n)
     * space complexity - O(n)
     * 
     * @param nums
     * @return
     */
    private static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0,end = nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(Math.abs(nums[start])>=Math.abs(nums[end])){
                result[i] = nums[start]*nums[start];
                start++;
            }else{
                result[i] = nums[end]*nums[end];
                end--;
            }
        }
        return result;
    }

    /**
     * find square of array elements and then sort the array
     * time complexity - O(nlogn)
     * space complexity - O(n)
     * 
     * @param nums
     * @return
     */
    public static int[] sortedSquaresV1(int[] nums) {
        for (int i=0;i<nums.length;i++){
            nums[i]= nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
