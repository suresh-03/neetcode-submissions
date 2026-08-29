class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        int[][] dp = new int[nums.length][totalSum * 2+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                dp[i][j] = -1;
            }
        }
        int ans = findTargetSumWays(0, nums, target, 0,dp,totalSum);

        // for(int i = 0; i < dp.length; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return ans;

    }

    public int findTargetSumWays(int index, int[] nums, int target, int sum,int[][] dp,int totalSum) {
        if (index == nums.length) {
            if(sum == target){
                return 1;
            }
            return 0;
        }

        int index2 = sum + totalSum;
        if(dp[index][index2] != -1){
            return dp[index][index2];
        }

        return dp[index][index2] = findTargetSumWays(index + 1, nums, target, sum + nums[index],dp,totalSum)
            + findTargetSumWays(index + 1, nums, target, sum - nums[index],dp,totalSum);
    }
}
