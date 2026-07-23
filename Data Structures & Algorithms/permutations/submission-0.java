class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums,ans,arr,visited);
        return ans;
    }

    public void permute(int[] nums, List<List<Integer>> ans, List<Integer> arr, boolean[] visited){
        if(arr.size() == nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
                continue;
            }
            arr.add(nums[i]);
            visited[i] = true;
            permute(nums,ans,arr,visited);
            visited[i] = false;
            arr.remove(arr.size()-1);
        }
    }
}
