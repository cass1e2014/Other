/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * Time O(n^k), space O(n) [[if k = 2, time O(n), space O(1)]]
 * 
 * @author cassie9082
 * 
 */
public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices){
		if(prices == null || prices.length == 0 || k == 0){
            return 0;
        }
        
        //k足够大的时候就相当于回答stockII
        if(k >= prices.length / 2){
            int profit = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > prices[i - 1]){
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        
        int n = prices.length;
        int[][] localProfit = new int[n ][k+1];//当前到达第i天可以最多进行j次交易，最好的利润是多少
        int[][] globalProfit = new int[n][k+1];//当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好利润是多少
        
        for(int j = 1; j <= k; j++){
            for(int i = 1; i < n; i++){
                localProfit[i][j] = Math.max(
                    localProfit[i-1][j] + prices[i]-prices[i-1],
                    globalProfit[i-1][j-1] + Math.max(0, prices[i] - prices[i-1]));
                    globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i-1][j]);
                    
            }
        }
        return globalProfit[n - 1][k];
	}
}
