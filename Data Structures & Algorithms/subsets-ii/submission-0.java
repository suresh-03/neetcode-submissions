class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0,nums,ans,new ArrayList<Integer>());
        return ans;
    }

    public void subsets(int index, int[] nums, List<List<Integer>> ans, List<Integer> list){
     
            ans.add(new ArrayList<>(list));
     
        for(int i = index; i < nums.length; i++){
            if(i != index && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            subsets(i+1,nums,ans,list);
            list.remove(list.size()-1);
        }
    }
}
