class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int[][] dp = new int[nums.length][sum / 2 + 1];

        return canPartition(0, nums, sum, 0, dp);
    }

    public boolean canPartition(int index, int[] nums, int totalSum, int sum, int[][] dp) {
        if (index >= nums.length) {
            return false;
        }
        if (sum > totalSum / 2) {
            return false;
        }
        if (totalSum - sum == sum) {
            return true;
        }

        if (dp[index][sum] != 0) {
            return dp[index][sum] == 1 ? true : false;
        }

        boolean take = false;
        if (sum <= totalSum / 2) {
            take = canPartition(index + 1, nums, totalSum, sum + nums[index], dp);
        }
        boolean notTake = canPartition(index + 1, nums, totalSum, sum, dp);

        dp[index][sum] = (take || notTake) == true ? 1 : -1;
        return take || notTake;

        // for (int i = index; i < nums.length; i++) {
        //     if (totalSum - sum == sum) {
        //         dp[index][sum] = 1;
        //         return true;
        //     }
        //     if (sum > totalSum / 2) {
        //         return false;
        //     }
        //     if (canPartition(i + 1, nums, totalSum, nums[i] + sum, dp)) {
        //         dp[index][sum] = 1;
        //         return true;
        //     }
        // }

        // dp[index][sum] = -1;
        // return false;
    }
}