package Arrays;

import java.util.Arrays;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] arr = new int[]{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] response = new int[temperatures.length];
        for (int i=0;i<temperatures.length;i++){
            for (int j=i+1;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    response[i] = j-i;
                    break;
                }
            }
        }
        return response;
    }
    
}
