class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = -1;
        }
        dp[0] = nums[0];
        int prev = nums[0];
        int prev2 = 0;

        for (int index = 1; index < nums.length; index++) {
            int curr = nums[index];
            int take = curr;
            if (index > 1) {
                take += prev2;
            }
            int notTake = 0 + prev;
            curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;

        // return dp[nums.length-1];

        // return rob(nums.length-1,nums,dp);
    }

    public int rob(int index, int[] nums, int[] dp) {
        if (index < 0) {
            return 0;
        }

        if (index == 0) {
            return nums[index];
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int take = nums[index] + rob(index - 2, nums, dp);
        int notTake = 0 + rob(index - 1, nums, dp);

        return dp[index] = Math.max(take, notTake);
    }
}
