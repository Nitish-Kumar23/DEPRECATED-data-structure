package Bitwise;

public class MagicNumber {
    public static void main(String[] args) {
        System.out.println(getMagicNumber(5));
    }

    private static int getMagicNumber(int n) {
        int counter = 1;
        int sum = 0;
        while (n!=0){
            int temp = n&1;
            sum = (int) (sum+(temp*Math.pow(5,counter)));
            n = n>>1;
            counter++;
        }
        return sum;
    }
}
