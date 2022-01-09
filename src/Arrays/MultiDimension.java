package Arrays;

import java.util.Scanner;

public class MultiDimension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 1 2 3 
         * 4 5 
         * 8 9 10 
         */
        int[][] arr = new int[3][3];
        int[][] arr2 = {
                {1, 2, 3}, //0th index
                {4, 5},  //1st index
                {8, 9, 10}};  //2nd index
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = scanner.nextInt();
            }
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        for (int row = 0; row < arr2.length; row++) {
            for (int col = 0; col < arr2[row].length; col++) {
                System.out.print(arr2[row][col] + " ");
            }
            System.out.println();
        }

    }
}
