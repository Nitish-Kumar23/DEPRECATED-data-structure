package Bitwise;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,2,3,7,43,43};
        System.out.println(singleNumber(arr));
    }

    private static int singleNumber(int[] arr) {
        int unique = 0;
        for (int number : arr){
            unique ^=number;
        }
        return unique;
    }
}
