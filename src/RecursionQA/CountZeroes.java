package RecursionQA;

public class CountZeroes {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(countZeroes(304021));
    }

    private static int countZeroes(int n) {
        if (n % 10 == n && n == 0) {
            return 1;
        }
        if (n % 10 == n && n != 0) {
            return 0;
        }
        int ans = countZeroes(n / 10);
        return n % 10 == 0 ? ans + 1 : ans;
    }

    private static int countZeroesV2(int n) {
        return helper(n, count);
    }

    private static int helper(int n, int count) {
        if (n % 10 == n) {
            return count;
        }
        int rem = n % 10;
        if (rem == 0) {
            return helper(n / 10, count + 1);
        }
        return helper(n / 10, count);
    }
}
