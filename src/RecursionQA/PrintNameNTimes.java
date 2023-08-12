package RecursionQA;

public class PrintNameNTimes {

    public static void main(String[] args) {
        print(5);
    }

    private static void print(int n) {
        if(n==0)
            return;
        System.out.println("hey");
        print(n-1);
    }
}
