package RecursionQA;

public class MinIncrement {
    public static void main(String[] args) {
        System.out.println(minimumIncrement(new int[]{1, 2, 2, 4, 2}, 0));
    }

    private static int minimumIncrement(int[] arr, int index) {
        if (index == arr.length - 1) {
            return 0;
        }
        return arr[index] == arr[index + 1] ? 1 + minimumIncrement(arr, index + 1) : minimumIncrement(arr, index + 1);
    }
}
