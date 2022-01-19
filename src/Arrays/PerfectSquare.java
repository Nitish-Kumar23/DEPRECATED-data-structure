package Arrays;

public class PerfectSquare {
    public static void main(String[] args) {
        System.out.println(Math.pow(21529600,0.5));
        System.out.println(isPerfectSquare(21529600));
    }

    private static boolean isPerfectSquare(int n) {
        int start=1;
        int end = n;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid*mid==(long)n)
                return true;
            if((long)mid*mid<(long)n){
                start=mid+1;
            }else if((long)mid*mid>(long)n){
                end=mid-1;
            }
        }
        return false;
    }
}
