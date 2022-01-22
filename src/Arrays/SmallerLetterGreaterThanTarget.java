package Arrays;

public class SmallerLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'c'));
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        if(letters[end]<=target){
            return letters[start];
        }
        while (start<=end){
            int mid = start+(end-start)/2;
            if(letters[mid]>target){
                end = mid-1;
            }
            else if (letters[mid]<=target){
                start = mid+1;
            }
        }
        return letters[start%letters.length];
    }
}
