package Arrays;

public class SingleElementSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5,6};
        System.out.println(getSingleElementSortedArray(arr));
    }

    private static int getSingleElementSortedArray(int[] nums) {
        int start =0,end=nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid-1>=0 && mid-1<nums.length && mid+1>=0 && mid+1<nums.length) {
                if ((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid + 1])) {
                    return nums[mid];
                }
                if (nums[mid] == nums[mid - 1]) {
                    if ((mid + 1) % 2 != 0) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
                if (nums[mid] == nums[mid + 1]) {
                    if ((mid + 1) % 2 == 0) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }else if(mid==0 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }else if(mid==end && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
        }
        return nums[start];
    }
}
