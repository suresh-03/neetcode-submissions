class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        subsets(nums,0,ans,arr);
        return ans;
    }

    public void subsets(int[] nums, int index, List<List<Integer>> ans,List<Integer> arr){
        if(index >= nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[index]);
        subsets(nums,index+1,ans,arr);
        arr.remove(arr.size()-1);
        subsets(nums,index+1,ans,arr);
    }
}
