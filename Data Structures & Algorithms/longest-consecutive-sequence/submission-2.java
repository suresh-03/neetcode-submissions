class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                continue;
            }
            list.add(num);
            set.add(num);
        }

        Collections.sort(list);

        int ans = 0;
        int count = 1;

        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i+1)-list.get(i) == 1){
                count++;
            }
            else{
                ans = Math.max(ans, count);
                count = 1;
            }
        }

        ans = Math.max(ans, count);

        return ans;

    }
}
