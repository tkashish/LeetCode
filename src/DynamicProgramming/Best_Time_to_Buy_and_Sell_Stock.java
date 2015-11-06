package DynamicProgramming;

public class Best_Time_to_Buy_and_Sell_Stock {
	public static int maxProfit(int[] prices) {
        int min = 0;
        int max = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[min] > prices[i]){
                min = i;
                max = i;
            }
            if(prices[max] < prices[i]){
                max = i;
            }
            if(max > min && profit < prices[max]-prices[min]){
                profit = prices[max]-prices[min];
            }   
        }
        return profit;
    }
}
