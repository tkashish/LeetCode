package DynamicProgramming;

public class Best_Time_To_Buy_and_Sell_Stock_III {
	int[] sol = null;
    int minX = 0;
    public int maxProfit(int[] prices) {
        sol = new int[prices.length];
        int maxProfit = 0;
        this.findMax(prices, 0, prices.length-1, true);
        maxProfit = sol[prices.length-1];
        for(int i = 0; i < prices.length; i++){
            System.out.print(sol[i] + " ");
        }
        System.out.println(minX);
        for(int i = 1; i < prices.length; i++){
            int profit = sol[i-1];
            int p1 = 0;
            if(i < minX){
                p1 += sol[prices.length-1];
            }else{
                p1 += this.findMax(prices, i, prices.length-1, false); 
            }
            System.out.println(p1 +"  " + sol[i-1] + " " + i);
            profit += p1;
            if(profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
    public int findMax(int[] prices, int i, int j, boolean flag){
        if(j < i) return 0;
        int Max = i;
        int Min = i;
        int profit = 0;
        if(flag){
        	this.sol[i] = 0;
        }
        for(int k = i+1; k < j+1; k++){
            if(prices[k] < prices[Min]) {
                Min = k;
                Max = k;
            }
            if(prices[k] > prices[Max]) Max = k;
            if(prices[Max]-prices[Min] > 0){
                profit=prices[Max]-prices[Min];
                if(flag){
                	this.minX = Min;             
                }
            }
            if(flag){
            	this.sol[k] = profit;
            }
        }
        return profit;
    }
    public static void main(String[] args){
    	int[] prices = {1,-2,3,1,-6,2,7,-1,-2,9};
    	Best_Time_To_Buy_and_Sell_Stock_III t = new Best_Time_To_Buy_and_Sell_Stock_III();
    	t.maxProfit(prices);
    }
}
