package DynamicProgramming;
/*
 * Accepted solution 
 */
public class Best_Time_To_Buy_and_Sell_Stock_III {
	int[] sol = null;
	int[] solNext = null;
	public int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		sol = new int[prices.length];
		int maxProfit = 0;
		solNext = new int[prices.length];
		this.findMax(prices);
		this.findMaxNext(prices);
		maxProfit = sol[prices.length-1];
		for(int i = 1; i < prices.length; i++){
			int profit = sol[i-1] + solNext[i];
			if(profit > maxProfit) maxProfit = profit;
		}
		return maxProfit;
	}
	public int findMaxNext(int[] price){
		int min = price.length-1;
		int max = price.length-1;
		int profit = 0;
		solNext[price.length-1] = 0;
		for(int i = price.length-2; i >= 0; i--){
			if(price[i] < price[min]){
				min = i;
			}
			if(price[i] > price[max]){
				min = i;
				max = i;
			}
			if(profit < price[max] - price[min]) profit =  price[max] - price[min];
			solNext[i] = profit;
		}
		return profit;
	}
	public int findMax(int[] prices){
		int Max = 0;
		int Min = 0;
		int profit = 0;
		this.sol[0] = 0;
		for(int k = 1; k < prices.length; k++){
			if(prices[k] < prices[Min]) {
				Min = k;
				Max = k;
			}
			if(prices[k] > prices[Max]) Max = k;
			if(prices[Max]-prices[Min] > 0){
				profit=prices[Max]-prices[Min];
			}
			this.sol[k] = profit;
		}
		return profit;
	}
	public static void main(String[] args){
		int[] prices = {1,-2,3,1,-6,2,7,-1,-2,9};
		Best_Time_To_Buy_and_Sell_Stock_III t = new Best_Time_To_Buy_and_Sell_Stock_III();
		System.out.println(t.maxProfit(prices));
	}
}
