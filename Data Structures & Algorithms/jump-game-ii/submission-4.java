class Solution {

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }
        return jump(0,nums,dp);
    }

    public int jump(int index, int[] nums,int[] dp){
        if(index >= nums.length-1){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int minJumps = 1000;

        for(int i = index+1; i <= Math.min(nums.length-1,nums[index]+index); i++){
            minJumps = Math.min(minJumps, 1 + jump(i,nums,dp));
        }
        return dp[index] = minJumps;
    }
}
