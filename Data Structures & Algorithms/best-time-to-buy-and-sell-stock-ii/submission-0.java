class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int i = 0; i < dp.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return maxProfit(0,prices,1,dp);
    }

    public int maxProfit(int index, int[] prices, int canBuy, int[][] dp){
        if(index == prices.length){
            return 0;
        }

        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }

        // buy case
        if(canBuy == 1){
            return dp[index][canBuy] = Math.max(-prices[index] + maxProfit(index+1,prices,0,dp),maxProfit(index+1,prices,1,dp));
        }

        // sell case
        return dp[index][canBuy] = Math.max(prices[index] + maxProfit(index+1,prices,1,dp),maxProfit(index+1,prices,0,dp));

    }
}