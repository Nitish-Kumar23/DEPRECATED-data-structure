package RecursionQA;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 32, 53, 112, 9};
        int target = 112;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(findIndex(arr, target, 0));
        System.out.println(findIndexLast(arr, target, arr.length - 1));

    }

    private static boolean linearSearch(int[] arr, int target, int index) {
        if (arr.length == index) {
            return false;
        }
        return arr[index] == target || linearSearch(arr, target, index + 1);
    }

    private static int findIndex(int[] arr, int target, int index) {
        if (arr.length == index) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, target, index + 1);
    }

    private static int findIndexLast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, target, --index);
    }

}
