class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        combinationSum(nums, target, 0, ans, arr, 0);
        return ans;
    }

    public void combinationSum(
        int[] nums, int target, int sum, List<List<Integer>> ans, List<Integer> arr, int index) {
        if (sum == target) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            if(sum > target){
                return;
            }
            arr.add(nums[i]);
            combinationSum(nums, target, sum + nums[i], ans, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }

  
}
