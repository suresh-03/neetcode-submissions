class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int minBuy = prices[0];

        int maxProfit = 0;

        for(int i = 1; i < n; i++){
            maxProfit = Math.max(prices[i]-minBuy,maxProfit);
            minBuy =  Math.min(prices[i],minBuy);
        }

        return maxProfit;
    }
}
