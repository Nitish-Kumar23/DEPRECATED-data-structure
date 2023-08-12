package Arrays;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        int currentPosition=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                nums[currentPosition++]=nums[i];
            }
        }
        return currentPosition;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k= removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }


}
