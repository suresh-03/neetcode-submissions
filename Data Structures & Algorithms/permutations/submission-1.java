class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums,0,ans);
        return ans;
    }

    public void permute(int[] nums, int index,List<List<Integer>> ans){
        if(index == nums.length - 1){
            List<Integer> list = new ArrayList<>();

            for(int num : nums){
                list.add(num);
            }
            ans.add(list);
            return;
        }

        for(int i = index; i < nums.length; i++){
            swap(nums,index,i);
            permute(nums,index+1,ans);
            swap(nums,index,i);
        }
    }

    public void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
