public class Recursion {
    public static void main(String[] args) {
        print1();    
    }

    private static void print1() {
        System.out.println("Hello World!");
        print2();
    }

    private static void print2() {
        System.out.println("Hello World!");
        print3();
    }

    private static void print3() {
        System.out.println("Hello World!");
        print4();
    }

    private static void print4() {
        System.out.println("Hello World!");
        print5();
    }

    private static void print5() {
        System.out.println("Hello World!");
    }
}
