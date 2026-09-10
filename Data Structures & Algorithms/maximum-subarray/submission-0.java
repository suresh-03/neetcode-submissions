class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            int sum = curSum + nums[i];
            if(sum > nums[i]){
                curSum = sum;
            }
            else{
                curSum = nums[i];
            }
            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }
}
