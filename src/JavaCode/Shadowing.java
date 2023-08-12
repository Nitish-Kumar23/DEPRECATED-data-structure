package JavaCode;

public class Shadowing {
    static int a = 50; //this value will be shadowed at line 7 as we have used local variable with same name

    public static void main(String[] args) {
        System.out.println(a);
        int a = 10;
        System.out.println(a);
        System.out.println(changeValue());
    }

    private static int changeValue() {
        a = 100;
        return a;
    }
}
