package Bitwise;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }

    private static boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        while (n!=1){
            if(n%2!=0)
                return false;
            else 
                n = n/2;
        }
        return true;
    }

    /**
     * If the number (n) is a power of 2 then it will have only single 1 bit rest all bits will be zero. Whereas (n-1) will have all 1 bits to left of MSB of n. Here take an example let's say n =8
     * (8)=00001000
     * (7)=00000111
     *
     * AND operation : 8 & 7 -> 0
     * Therefore for n to be power of 2 it has to be greater than zero and n&(n-1)==0
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfTwoV1(int n) {
        int ans = n&n-1;
        return n>0 && ans==0;
    }
}
