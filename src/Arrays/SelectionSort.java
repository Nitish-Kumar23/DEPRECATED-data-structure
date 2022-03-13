package Arrays;

import java.util.Arrays;

public class SelectionSort implements ArraySort{
    
    public static void main(String[] args) {
        int[] arr = {5,40,33,2,1,31,12};
        System.out.println(Arrays.toString(arr));
        ArraySort arraySort = new SelectionSort();
        arraySort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * pick out minimum or maximum element and put it at right position
     * time complexity - O(n^2)
     * performs well on small list
     * @param arr
     */
    @Override
    public void sort(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            int minimum = arr[i];
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<minimum){
                    minimum = arr[j];
                    minIndex = j;
                }
            }
            //swap
            arr[minIndex] = arr[i];
            arr[i] = minimum;
            Arrays.sort(arr);
        }
    }
}
