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

    /**
     * returns target element index in array
     *
     * @param array
     * @param target
     * @return
     */
    private static int linearSearch(int[] array, int target) {
        if (array == null || array.length == 0)
            return -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }
}
