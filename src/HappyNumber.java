import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    //https://leetcode.com/problems/happy-number/
    public static boolean isHappy(int n) {
        Map<Integer,Boolean> map = new HashMap<>();
        int square=0;
        while (true){
            if(map.containsKey(n)){
                return false;
            }
            square = getSquareSumOfDigits(n);
            if(square==1){
                return true;
            }
            map.put(n,true);
            n = square;
        }
    }

    public static int getSquareSumOfDigits(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum = sum+(rem*rem);
            n = n/10;
        }
        return sum;
    }
}
