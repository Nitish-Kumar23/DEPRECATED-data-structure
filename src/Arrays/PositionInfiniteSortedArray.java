package Arrays;

public class PositionInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,8,10,15,21,23,35,42,79,81,85,90,93};
        System.out.println(getElementPositionInfiniteSortedArray(arr,79));
    }

    private static int getElementPositionInfiniteSortedArray(int[] arr, int target) {
        int start=0,end=0;
        int size = 1;
        while (start<=end){
            if(arr[start]==target){
                return start;
            }
            if(arr[end]==target){
                return end;
            }
            if(arr[start]<target&&arr[end]>target){
                return searchElement(arr,target,start,end);
            }else if(arr[start]<target && arr[end]<target){
                start = end+1;
                size = 2*size;
                end = start+(size-1);
            }
        }
        return -1;
    }

    private static int searchElement(int[] arr, int target, int start, int end) {
        while (start<=end) {
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start=mid+1;
            }else if(arr[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }
}
