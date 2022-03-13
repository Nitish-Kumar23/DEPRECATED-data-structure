package Arrays;

import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(arr));
        int[] result = mergeSort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int s1 = 0, s2 = 0;
        int index = 0;
        while (s1 < left.length && s2 < right.length) {
            if (arr[s1] < arr[s2]) {
                arr[index++] = left[s1++];
            } else {
                arr[index++] = right[s2++];
            }
        }
        while (s1 < left.length) {
            arr[index++] = left[s1++];
        }
        while (s2 < right.length) {
            arr[index++] = right[s2++];
        }
        return arr;
    }
    
    /**
    @Override
    public void sort(int[] arr) {
        mergeSortV1(arr, 0, arr.length - 1);
        return;
    }
    
    private void mergeSortV1(int[] arr, int start, int end) {
        if (start > end)
            return;

        int mid = start + (end - start) / 2;
        mergeSortV1(arr, 0, mid);
        mergeSortV1(arr, mid + 1, end);
        mergeV1(arr,start,mid,end);
    }

    private void mergeV1(int[] arr,int start,int mid,int end) {
        int s1 = start, s2 = mid + 1;
        int[] result = new int[arr.length];
        int index = 0;
        while (s1 <= mid && s2 <= end) {
            if (arr[s1] < arr[s2]) {
                result[index++] = arr[s1++];
            } else {
                result[index++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            result[index++] = arr[s1++];
        }
        while (s2 <= end) {
            result[index++] = arr[s2++];
        }
        copyArray(result, arr);
    }

    private void copyArray(int[] result, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }
    **/

}
