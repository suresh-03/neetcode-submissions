class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];

        // for(int i = 0; i < dp.length; i++){
        //     dp[i][0] = -1;
        //     dp[i][1] = -1;
        // }
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for (int index = prices.length - 1; index >= 0; index--) {
            // buy case
            dp[index][1] = Math.max(-prices[index] + dp[index + 1][0], dp[index + 1][1]);

            // sell case
            dp[index][0] = Math.max(prices[index] + dp[index + 1][1], dp[index + 1][0]);
        }

        // return maxProfit(0,prices,1,dp);
        return dp[0][1];
    }

    public int maxProfit(int index, int[] prices, int canBuy, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        // buy case
        if (canBuy == 1) {
            return dp[index][canBuy] =
                       Math.max(-prices[index] + maxProfit(index + 1, prices, 0, dp),
                           maxProfit(index + 1, prices, 1, dp));
        }

        // sell case
        return dp[index][canBuy] = Math.max(prices[index] + maxProfit(index + 1, prices, 1, dp),
                   maxProfit(index + 1, prices, 0, dp));
    }
}