package RecursionExp;

public class ReverseNumber {
    static int reverse = 0;

    public static void main(String[] args) {
        System.out.println(getReverse(1342));
        reverseNumber(1342);
        System.out.println(reverse);
    }

    private static void reverseNumber(int n) {
        if (n == 0) {
            return;
        }
        reverse = reverse * 10 + n % 10;
        reverseNumber(n / 10);
    }

    public static int getReverse(int n) {
        int digits = (int) (Math.log10(n) + 1);
        return reverseNumberV2(n, digits);
    }

    private static int reverseNumberV2(int n, int digits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return (int) (rem * Math.pow(10, digits - 1) + reverseNumberV2(n / 10, digits - 1));
    }
}
