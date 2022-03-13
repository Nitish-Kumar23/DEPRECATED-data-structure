package Arrays;

import java.util.Arrays;

/**
 * Bubble sort also known as sinking sort or exchange sort
 */
public class BubbleSort implements ArraySort{

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        ArraySort arraySort = new BubbleSort();
        arraySort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    @Override
    public void sort(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
