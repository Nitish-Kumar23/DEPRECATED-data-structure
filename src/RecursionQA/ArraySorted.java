package RecursionQA;

public class ArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9,12};
        System.out.println(isSortedArray(arr,0));
    }

    private static boolean isSortedArray(int[] arr, int index) {
        if(arr.length-1==index)
            return true;
        return arr[index]<arr[index+1] && isSortedArray(arr,index+1);
    }
}
