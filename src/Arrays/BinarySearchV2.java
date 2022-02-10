package Arrays;

public class BinarySearchV2 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 23, 65, 90};
        System.out.println(binarySearch(arr, 65, 0, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, end);
        }
        return binarySearch(arr, target, start, mid - 1);
    }
}
