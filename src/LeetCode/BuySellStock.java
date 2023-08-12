package LeetCode;

public class BuySellStock {

    // 2,1,2,1,0,1,2
    // 1,2,4,2,5,7,2,4,9,0,9
    // 7,1,5,3,6,4
    // 1,2,1,2,1,3,5,1
    public static int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int maxProfit = 0;
        int buyIndex = 0;
        int sellIndex = 1;
        while (buyIndex<prices.length && sellIndex<prices.length){
            int profit = prices[sellIndex] - prices[buyIndex];
            if(profit>maxProfit){
                maxProfit = profit;
            }
            if(profit==0){
                sellIndex++;
            }
            if(profit>0){
                sellIndex++;
            }
            if(profit<0){
                buyIndex = sellIndex;
                sellIndex++;
            }
        }
        return maxProfit;
        
    }
    
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,1,2,1,3,5,1}));
    }
}

