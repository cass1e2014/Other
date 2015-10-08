/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * 根据题目要求，最多进行两次买卖股票，而且手中不能有2只股票，就是不能连续两次买入操作。k = 2
 * Solution: 1-d DP, Time ~ O(3N)
 * Let d(i) be the max profit when 1st transaction is in [0, i] and 2nd transaction is in [i, N - 1].
 * d(i) = f(i) + g(i) where
 * f(i) = max{f(i - 1), p[i] - p_min}
 * g(i) = max{g(i + 1), p_max - p[i]}
 * profit_max = max_{0 <= i <= N-1} {f(i) + g(i)}
 * 
 */

public class BestTimeToBuyAndSellStockIII {
	public static int maxProfit(int[] prices) {
		//N < 2 无法进行transaction

		if(prices == null || prices.length < 2){
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
    
        //o(n)
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
	}
}
