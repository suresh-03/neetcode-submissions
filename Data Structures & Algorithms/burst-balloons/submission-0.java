class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        int[] modifiedNums = new int[nums.length+2];
        for(int i = 0; i <= nums.length; i++){
            for(int j = 0; j <= nums.length; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < nums.length; i++){
            modifiedNums[i+1] = nums[i];
        }

        modifiedNums[0] = 1;
        modifiedNums[nums.length+1] = 1;

        return f(1,nums.length,modifiedNums,dp);
    }

    public int f(int i, int j, int[] nums, int[][] dp){
        if(j < i){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++){
            int coins = nums[i-1] * nums[ind] * nums[j+1] + f(i,ind-1,nums,dp) + f(ind+1,j,nums,dp);

            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }
}
