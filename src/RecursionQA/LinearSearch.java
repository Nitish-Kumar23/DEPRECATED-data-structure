package RecursionQA;

import java.util.ArrayList;

public class LinearSearch {
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 32, 53, 112, 112, 9};
        int target = 112;
        System.out.println(linearSearch(arr, target, 0));
        System.out.println(findIndex(arr, target, 0));
        System.out.println(findIndexLast(arr, target, arr.length - 1));
        findAllIndices(arr, target, 0);
        System.out.println(result);
        System.out.println(findAllIndices(arr, target, 0, new ArrayList<>()));

    }

    /**
     * check if element exists or not
     *
     * @param arr
     * @param target
     * @param index
     * @return
     */
    private static boolean linearSearch(int[] arr, int target, int index) {
        if (arr.length == index) {
            return false;
        }
        return arr[index] == target || linearSearch(arr, target, index + 1);
    }

    /**
     * return target element index
     *
     * @param arr
     * @param target
     * @param index
     * @return
     */
    private static int findIndex(int[] arr, int target, int index) {
        if (arr.length == index) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, target, index + 1);
    }

    /**
     * return target element index if we start from last index
     *
     * @param arr
     * @param target
     * @param index
     * @return
     */
    private static int findIndexLast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        }
        return findIndex(arr, target, --index);
    }

    /**
     * Method to return multiple occurrence of target element in an array
     *
     * @param arr
     * @param target
     * @param index
     */
    private static void findAllIndices(int[] arr, int target, int index) {
        if (arr.length == index) {
            return;
        }
        if (arr[index] == target) {
            result.add(index);
        }
        findAllIndices(arr, target, index + 1);
    }

    /**
     * returns an arraylist of multiple occurrence of indexes
     * 
     * @param arr
     * @param target
     * @param index
     * @param output
     * @return
     */
    private static ArrayList<Integer> findAllIndices(int[] arr, int target, int index, ArrayList<Integer> output) {
        //if we iterated till last element then it means we have added all the index in the output arraylist simply return that list
        if (arr.length == index) {
            return output;
        }
        if (arr[index] == target) {
            output.add(index);
        }
        //we are passing output arraylist in recursion call and adding indexes in it
        return findAllIndices(arr, target, index + 1, output);
    }

}
