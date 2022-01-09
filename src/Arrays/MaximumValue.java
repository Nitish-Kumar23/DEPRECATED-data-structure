package Arrays;

public class MaximumValue {
    public static void main(String[] args) {
        int[] arr = {21, 53, 64, -1, 53, 78};
        System.out.println(maximumItem(arr));
    }

    /**
     * returns maximum value in the given array
     *
     * @param arr
     * @return
     */
    private static int maximumItem(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max)
                max = value;
        }
        return max;
    }
}
