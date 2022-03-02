package Arrays;

class SearchInsert {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr,5));
    }
    public static int searchInsert(int[] nums, int target) {
        return searchInsertTarget(nums,0,nums.length-1,target);
    }
    
    public static int searchInsertTarget(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start++;
            } else if (arr[mid] > target) {
                end--;
            }
        }
        return start;
    }
}