package Arrays;

import Utils.ArrayUtils;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = ArrayUtils.getArrayInt();
        int target = scanner.nextInt();
        System.out.println(linearSearch(array, target));
    }

    private static int linearSearch(int[] array, int target) {
        for (int i = 0; i< array.length; i++){
            if(array[i]== target){
                return i;
            }
        }
        return -1;
    }
}
