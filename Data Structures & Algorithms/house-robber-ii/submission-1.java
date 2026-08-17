class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int temp = nums[0];
        nums[0] = 0;
        int skipFirst = rob1(nums);
        nums[0] = temp;
        nums[nums.length-1] = 0;
        int skipLast = rob1(nums);

        return Math.max(skipFirst,skipLast);
    }
    public int rob1(int[] nums) {
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

        // space optimization
        return prev;

        // tabulation
        // return dp[nums.length-1];

        // memoization
        // return rob(nums.length-1,nums,dp);
    }
}
