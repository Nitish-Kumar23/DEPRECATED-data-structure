package Arrays;

public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(getPeakIndexMountainArray(arr));
    }

    private static int getPeakIndexMountainArray(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid==0){
                start=mid+1;
                continue;
            }else if(mid== arr.length-1){
                end = mid-1;
                continue;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                end = mid-1;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                start=mid+1;
            }
        }
        return -1;
    }
}
