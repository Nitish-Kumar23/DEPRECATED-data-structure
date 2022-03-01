package Bitwise;

public class NumberOfDigits {
    public static void main(String[] args) {
        System.out.println(getDigits(5,2));
    }
    
    //get number of digits in the binary representation of n (only if b=2)
    private static int getDigits(int n,int b) {
        return n==0?0:(int) (Math.log(n)/Math.log(b))+1;
    }

    /**
     * time complexity - O(n)
     * @param n
     * @return
     */
    private static int getDigitsV1(int n) {
        // AND n with 1, right shift and increment counter by 1
        int count = 0;
        while (n!=0){
            int temp = n&1;
            count++;
            n = n>>1;
        }
        return count;
    }
}
