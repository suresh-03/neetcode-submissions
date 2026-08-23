class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        return canPartition(0,nums,sum,0);
    }

    public boolean canPartition(int index,int[] nums, int totalSum, int sum){

        for(int i = index; i < nums.length; i++){
            if(totalSum - sum == sum){
                return true;
            }
            if(canPartition(i+1,nums,totalSum,nums[i]+sum)){
                return true;
            }
           
        }

        return false;
    }
}
