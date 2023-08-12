package RecursionExp;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {11, 12, 15, 17, 1, 3, 7, 8, 9};
        System.out.println(binarySearch(arr, 3, 0, arr.length - 1));
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return -1;
        }
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (arr[start] <= target && arr[mid] >= target) {
                return binarySearch(arr, target, start, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, end);
            }
        }
        if (target >= arr[mid] && target <= arr[end]) {
            return binarySearch(arr, target, mid + 1, end);
        }
        return binarySearch(arr, target, start, mid - 1);
    }
}
