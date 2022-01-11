package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MaximumCandies {
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.println(maximumCandies(candies,extraCandies));
    }

    /**
    private static boolean[] maximumCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int number : candies){
            if(number>maxCandies) {
                maxCandies = number;
            }
        }
        boolean[] result = new boolean[candies.length];
        for (int i=0;i<candies.length;i++){
            result[i] = candies[i] + extraCandies >= maxCandies;
        }
        return result;
    }
     */

    private static List<Boolean> maximumCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        for (int number : candies){
            if(number>maxCandies) {
                maxCandies = number;
            }
        }
        ArrayList<Boolean> result = new ArrayList();
        boolean ans;
        for (int i=0;i<candies.length;i++){
            ans = candies[i] + extraCandies >= maxCandies;
            result.add(ans);
        }
        return result;
    }
}
