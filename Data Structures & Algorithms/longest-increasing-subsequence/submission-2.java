class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                dp[i][j] = -1;
            }
        }

        return solve(0,nums,-1,dp);
    }

    public int solve(int index, int[] nums, int lastTake,int[][] dp){
        if(index >= nums.length){
            return 0;
        }

        if(dp[lastTake == -1 ? index : lastTake][index] != -1){
            return dp[lastTake][index];
        }
        int take = 0;
        if(lastTake == -1 || nums[lastTake] < nums[index]){
            take = 1 + solve(index+1,nums,index,dp);
        }
        int notTake = 0 + solve(index+1,nums,lastTake,dp);


        return dp[lastTake == -1 ? index : lastTake][index] = Math.max(take,notTake);
    }
}
