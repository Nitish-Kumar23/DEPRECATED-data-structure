package Bitwise;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    private static int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i=0;i<=n;i++){
            ans[i] = getBits(i);
        }
        return ans;
    }

    private static int getBits(int n) {
        int count = 0;
        while (n!=0){
             int temp = n&1;
             if(temp==1) {
                 count++;
             }
             n = n>>1;
        }
        return count;
    }
}
