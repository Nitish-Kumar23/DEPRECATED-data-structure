package Arrays;

public class SearchInRange {
    public static void main(String[] args) {
        int[] input = {18, 10, 15, 37, 318, 94, 73};
        int target = 37;
        int start = 1;
        int end = 4;
        System.out.println(linearSearch(input, target, start, end));
    }

    /**
     * returns index of target element between index range if exists else return -1
     *
     * @param input
     * @param target
     * @param start
     * @param end
     * @return
     */
    private static int linearSearch(int[] input, int target, int start, int end) {
        if (input == null || input.length == 0 || start < 0 || end >= input.length)
            return -1;
        for (int index = start; index <= end; index++) {
            if (input[index] == target)
                return index;
        }
        return -1;
    }
}
