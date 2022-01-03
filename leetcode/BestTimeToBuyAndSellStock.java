package leetcode;

/*
LC Easy : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* **/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitII(prices));
    }

    public static int maxProfit(int[] prices) {
        return helper(prices, 0, 1);
    }

    private static int helper(int[] prices, int buy, int sell) {
        if(sell>= prices.length || buy>=sell) return 0;
        int profit = Math.max(prices[sell] - prices[buy], 0);
        return Math.max(profit, Math.max(helper(prices, buy, sell+1), helper(prices, buy+1, sell)));
    }

    private static int maxProfitII(int[] prices) {
        int minPrice = Integer.MAX_VALUE; int maxProfit = 0;
        for(int i = 0; i<prices.length; i++) {
            if(prices[i]<minPrice)
                minPrice = prices[i];
            else if(prices[i]-minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
