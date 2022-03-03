package Arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {-1,2};
        System.out.println(Arrays.toString(rotateArray(arr,3)));
    }

    private static int[] rotateArray(int[] arr, int k) {
        if(k==0)
            return arr;
        if(k>arr.length){
            int rotation = k%arr.length;
            while (rotation>0){
                int end = arr.length-1;
                int temp = arr[end];
                for(int i=end;i>=1;i--){
                    arr[i] = arr[i-1];
                }
                arr[0] = temp;
                rotation--;
            }
        }else {
            int[] temp = new int[k];
            int pos = 0;
            for (int i = arr.length - k; i < arr.length; i++) {
                temp[pos++] = arr[i];
            }
            for (int i = arr.length - k - 1; i >= 0; i--) {
                arr[i + k] = arr[i];
            }
            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
        }
        return arr;
    }
}
