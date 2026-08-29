class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for(int i = 0; i < prices.length; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return solve(0,prices,1,dp);
    }

    public int solve(int index, int[] prices, int canBuy, int[][] dp){
        if(index >= prices.length){
            return 0;
        }

        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }

        if(canBuy == 1){
            return dp[index][canBuy] = Math.max(-prices[index] + solve(index+1,prices,0,dp),solve(index+1,prices,1,dp));
        }

        return dp[index][canBuy] = Math.max(prices[index] + solve(index+2,prices,1,dp),solve(index+1,prices,0,dp));
        
    }
}
