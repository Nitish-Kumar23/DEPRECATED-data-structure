package Arrays;

import Utils.ArrayUtils;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = ArrayUtils.getArrayInt();
        int number = scanner.nextInt();
        for (int i=0;i<array.length;i++){
            if(array[i]==number){
                System.out.println("Number exists at index"+i);
                return;
            }
        }
        System.out.println(-1);
    }
}
