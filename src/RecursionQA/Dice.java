package RecursionQA;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        diceCount(4,"");
        System.out.println("Total dice combinations " + count);
        System.out.println(diceCountRet(4,""));
        diceCountV3(8,8,"");
    }
    
    static int count = 0;
    private static void diceCount(int target,String currentSum) {
        if(target==0){
            count++;
            System.out.println(currentSum);
            return;
        }
        for (int i=1;i<=6 && i<=target;i++){
            diceCount(target-i,currentSum+i);
        }
    }

    private static ArrayList<String> diceCountRet(int target, String currentSum) {
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(currentSum);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i=1;i<=6 && i<=target;i++){
            result.addAll(diceCountRet(target-i,currentSum+i));
        }
        return result;
    }

    private static void diceCountV3(int target,int k, String currentSum) {
        if(target==0){
            count++;
            System.out.println(currentSum);
            return;
        }
        for (int i=1;i<=k && i<=target;i++){
            diceCount(target-i,currentSum+i);
        }
    }
}
