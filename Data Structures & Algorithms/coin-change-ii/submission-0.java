class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        for(int i = 0; i < coins.length; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }
        return change(0,amount,coins,dp);
    }

    public int change(int index, int amount, int[] coins,int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(amount < 0){
            return 0;
        }
        if(dp[index][amount] != -1){
            return dp[index][amount];
        }
        int ans = 0;
        for(int i = index; i < coins.length; i++){
            ans += change(i,amount - coins[i],coins,dp);
        }
        return dp[index][amount] = ans;
    }
}
