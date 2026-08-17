class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            dp[i] = -1;
        }
        dp[0] = nums[0];

        for(int index = 1; index < nums.length; index++){
            int take = nums[index];
            if(index > 1) {
                take += dp[index-2];
            }
            int notTake = 0 + dp[index-1];
            dp[index] = Math.max(take,notTake);
        }

        return dp[nums.length-1];

        // return rob(nums.length-1,nums,dp);
    }

    public int rob(int index,int[] nums,int[] dp){
        if(index < 0){
            return 0;
        }

        if(index == 0){
            return nums[index];
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int take = nums[index] + rob(index-2,nums,dp);
        int notTake = 0 + rob(index-1,nums,dp);

        return dp[index] = Math.max(take,notTake);
    }
}
