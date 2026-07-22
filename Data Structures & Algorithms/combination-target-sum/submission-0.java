class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        combinationSum(nums,target,0,ans,arr,0);
        return ans;
    }

    public void combinationSum(int[] nums, int target, int sum, List<List<Integer>> ans, List<Integer> arr,int index){
        if(sum == target){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(sum > target){
            return;
        }

        for(int i = index; i < nums.length; i++){
            arr.add(nums[i]);
            combinationSum(nums,target,sum + nums[i],ans,arr,i);
            arr.remove(arr.size()-1);
        }
    }
}
