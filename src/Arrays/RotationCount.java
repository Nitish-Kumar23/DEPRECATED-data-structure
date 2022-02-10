package Arrays;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {8,9,12,16,37,2,3,5,7};
        System.out.println(getRotationCount(arr));
    }

    //https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
    private static int getRotationCount(int[] arr) {
        return SearchRotatedArray.getPivot(arr)+1;
    }
}
