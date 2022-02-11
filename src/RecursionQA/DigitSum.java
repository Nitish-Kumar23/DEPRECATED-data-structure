package RecursionQA;

public class DigitSUm {
    public static void main(String[] args) {
        System.out.println(digitSum(1342));
    }

    private static int digitSum(int n) {
        if(n==0)
            return 0;
        return n%10+digitSum(n/10);
    }
}
