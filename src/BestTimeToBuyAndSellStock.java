/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * 
 * 只能做一次transaction，所以要在价格最低的时候买，价格最高的时候卖
 * 买价的日期要早于卖价的日期
 * 遍历一次数组，维护一个最小买价和一个最大利润就可以

 */

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;	
    }
}
