class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            memo[i] = -1;
        }
        return dfs(0,nums,memo);
    }

    public int dfs(int index, int[] nums, int[] memo){
        if(index >= nums.length){
            return 0;
        }

        if(memo[index] != -1){
            return memo[index];
        }

        return memo[index] = Math.max(nums[index] + dfs(index+2,nums,memo),dfs(index+1,nums,memo));
    }
}
