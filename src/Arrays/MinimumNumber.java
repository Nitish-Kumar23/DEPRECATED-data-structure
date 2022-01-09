package Arrays;

import Utils.ArrayUtils;

public class MinimumNumber {
    public static void main(String[] args) {
        int[] arr = ArrayUtils.getArrayInt();
        System.out.println(minimumNumber(arr));
    }

    /**
     * find minimum number in the array
     *
     * @param arr
     * @return
     */
    private static int minimumNumber(int[] arr) {
        //considering array length is not null and length>0
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value < min)
                min = value;
        }
        return min;
    }
}
