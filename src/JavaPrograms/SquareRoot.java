package JavaPrograms;

public class SquareRoot {
    public static void main(String[] args) {
        int num = 170;
        System.out.println(getSquareRoort(num));
    }

    private static int getSquareRoort(int num) {
        int start = 1;
        int end=num;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid*mid==num){
                return mid;
            }else if(mid*mid>num){
                end = mid-1;
            }else if (mid*mid<num){
                start = mid+1;
            }
        }
        return 0;
    }
}
