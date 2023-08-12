package Arrays;

public class SumSubarrayMinimum {
    public static void main(String[] args) {
        int[] arr = {3,1,2,4};
        System.out.println(sumSubArrayMinimum(arr));
    }

    private static int sumSubArrayMinimum(int[] arr) {
        int mod = 1_000_000_007;
        int minSum = 0;
        for (int i=0;i<arr.length;i++){
            minSum = minSum+arr[i];
            int minValue = arr[i];
            for (int j=i+1;j<arr.length;j++){
                if(arr[j]<minValue){
                    minValue = arr[j];
                    minSum = minSum+minValue;
                    continue;
                }
                minSum = minSum+minValue;
            }
        }
        return minSum % mod;
    }
}
