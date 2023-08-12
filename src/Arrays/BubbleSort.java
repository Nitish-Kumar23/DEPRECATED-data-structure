package Arrays;

import java.util.Arrays;

/**
 * Bubble sort also known as sinking sort or exchange sort
 * stable sorting algorithm - when order is maintained for two or more equal values
 */
public class BubbleSort implements ArraySort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        ArraySort arraySort = new BubbleSort();
        arraySort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * time complexity - O(n^2)
     * best case - O(n) if array is already sorted
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            boolean swapped = false;
            for (int j=0;j<arr.length-i-1;j++){
                //swap if the item is smaller than previous element
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            //break if there are no swap then it means array is sorted
            if(i==0 && !swapped)
                return;
        }
    }
}
